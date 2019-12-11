package com.trunghoang.restaurant.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.trunghoang.restaurant.exceptions.ApplicationException;
import com.trunghoang.restaurant.services.IService;

/**
 * 
 * 
 *
 * @param <DTO>
 * @param <SERVICE>
 */
public abstract class DefaultController<DTO, SERVICE extends IService<DTO>> implements IController<DTO> {

	private Logger log = LoggerFactory.getLogger(DefaultController.class);

	public abstract SERVICE getService();

	@GetMapping(value = "/")
	@Override
	public ResponseEntity<List<DTO>> getAll(@RequestParam(value = "pageNumer") int pageNumber,
			@RequestParam(value = "numberOfRecord") int numberOfRecord) {
		return new ResponseEntity<>(getService().findAll(pageNumber, numberOfRecord), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	@Override
	public ResponseEntity<DTO> findById(@PathVariable long id) {
		return new ResponseEntity<>(getService().findById(id), HttpStatus.OK);
	}

	@PostMapping(value = "/")
	@Override
	public ResponseEntity<Void> add(@RequestBody DTO dto) {
		getService().add(dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping(value = "/")
	@Override
	public ResponseEntity<Void> update(@RequestBody DTO dto) throws ApplicationException {
		getService().update(dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	@Override
	public ResponseEntity<Void> delete(@PathVariable long id) throws ApplicationException {
		getService().delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Log event for controller
	 * 
	 * @param message
	 */
	public void logEvent(String message) {
		if (log.isInfoEnabled()) {
			log.info(message);
		}
	}
}
