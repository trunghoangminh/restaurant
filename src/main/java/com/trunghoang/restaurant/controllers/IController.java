package com.trunghoang.restaurant.controllers;

import com.trunghoang.restaurant.exceptions.ApplicationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 
 * Controller interface
 *
 * @param <DTO>
 */
public interface IController<DTO> {

	public ResponseEntity<List<DTO>> getAll(int pageNumber, int numberOfRecord);

	public ResponseEntity<DTO> findById(@PathVariable long id);

	public ResponseEntity<DTO> add(@RequestBody DTO dto);

	public ResponseEntity<DTO> update(@RequestBody DTO dto) throws ApplicationException;

	public ResponseEntity<Void> delete(@PathVariable long id) throws ApplicationException;
}
