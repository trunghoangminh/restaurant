package com.trunghoang.restaurant.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.trunghoang.restaurant.exceptions.ApplicationException;

/**
 * 
 * Controller interface
 *
 * @param <DTO>
 */
public interface IController<DTO> {

	public ResponseEntity<List<DTO>> getAll(int pageNumber, int numberOfRecord);

	public ResponseEntity<DTO> findById(@PathVariable long id);

	public ResponseEntity<Void> add(@RequestBody DTO dto);

	public ResponseEntity<Void> update(@RequestBody DTO dto);

	public ResponseEntity<Void> delete(@PathVariable long id) throws ApplicationException;
}
