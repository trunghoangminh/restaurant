package com.trunghoang.restaurant.services;

import com.trunghoang.restaurant.exceptions.ApplicationException;

import java.util.List;

/**
 * 
 * Interface for service layer
 *
 * @param <DTO>
 */
public interface IService<DTO> {

	public List<DTO> findAll(int pageNumber, int numberOfRecord);

	public DTO findById(long id);

	public DTO add(DTO dto);

	public DTO update(DTO dto) throws ApplicationException;

	public void delete(long id) throws ApplicationException;
}
