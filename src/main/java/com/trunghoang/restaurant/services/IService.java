package com.trunghoang.restaurant.services;

import java.util.List;

import com.trunghoang.restaurant.exceptions.ApplicationException;

/**
 * 
 * Interface for service layer
 *
 * @param <DTO>
 */
public interface IService<DTO> {

	public List<DTO> findAll(int pageNumber, int numberOfRecord);

	public DTO findById(long id);

	public void add(DTO dto);

	public void update(DTO dto) throws ApplicationException;

	public void delete(long id) throws ApplicationException;
}
