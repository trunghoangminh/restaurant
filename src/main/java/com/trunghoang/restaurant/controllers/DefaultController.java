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
import org.springframework.web.bind.annotation.ResponseBody;

import com.trunghoang.restaurant.services.IService;

/**
 * 
 * 
 *
 * @param <DTO>
 * @param <SERVICE>
 */
public abstract class DefaultController<DTO, SERVICE extends IService<DTO>> {

	private Logger log = LoggerFactory.getLogger(DefaultController.class);

	public abstract SERVICE getService();

	@GetMapping(value = "/")
	@ResponseBody
	public ResponseEntity<List<DTO>> getAll() {
		return new ResponseEntity<>(getService().findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<DTO> findById(@PathVariable long id) {
		return new ResponseEntity<>(getService().findById(id), HttpStatus.OK);
	}

	@PostMapping(value = "/")
	@ResponseBody
	public ResponseEntity<DTO> add(@PathVariable DTO dto) {
		getService().add(dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping(value = "/")
	@ResponseBody
	public ResponseEntity<DTO> update(@PathVariable DTO dto) {
		getService().update(dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<DTO> delete(@PathVariable long id) {
		return new ResponseEntity<>(getService().findById(id), HttpStatus.OK);
	}

}
