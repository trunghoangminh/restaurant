package com.trunghoang.restaurant.services;

import java.util.List;

/**
 * 
 * Interface for service layer
 *
 * @param <DTO>
 */
public interface IService<DTO> {

	public List<DTO> findAll();

	public DTO findById(long id);

	public void add(DTO dto);

	public void update(DTO dto);

	public void delete(DTO dto);
}
