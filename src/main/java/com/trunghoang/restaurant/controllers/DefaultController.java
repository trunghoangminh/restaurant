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
import org.springframework.web.bind.annotation.ResponseBody;

import com.trunghoang.restaurant.exceptions.ApplicationException;
import com.trunghoang.restaurant.services.IService;

import io.swagger.annotations.ApiOperation;

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

	@ApiOperation(value = "")
	@GetMapping(value = "/")
	@ResponseBody
	@Override
	public ResponseEntity<List<DTO>> getAll(@RequestParam(value = "pageNumer") int pageNumer,
			@RequestParam(value = "numberOfRecord") int numberOfRecord) {
		return new ResponseEntity<>(getService().findAll(pageNumer, numberOfRecord), HttpStatus.OK);
	}

	@ApiOperation(value = "")
	@GetMapping(value = "/{id}")
	@ResponseBody
	@Override
	public ResponseEntity<DTO> findById(@PathVariable long id) {
		return new ResponseEntity<>(getService().findById(id), HttpStatus.OK);
	}

	@ApiOperation(value = "")
	@PostMapping(value = "/")
	@ResponseBody
	@Override
	public ResponseEntity<Void> add(@RequestBody DTO dto) {
		getService().add(dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "")
	@PutMapping(value = "/")
	@ResponseBody
	@Override
	public ResponseEntity<Void> update(@RequestBody DTO dto) {
		getService().update(dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "")
	@DeleteMapping(value = "/{id}")
	@ResponseBody
	@Override
	public ResponseEntity<Void> delete(@PathVariable long id) throws ApplicationException {
		getService().delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
