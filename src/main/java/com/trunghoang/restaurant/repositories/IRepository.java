package com.trunghoang.restaurant.repositories;

import java.util.List;

/**
 * 
 * Repository interface
 *
 * @param <ENTITY>
 */
public interface IRepository<ENTITY> {

	public List<ENTITY> getAll();

	public ENTITY findById(long id);

	public void add(ENTITY entity);

	public void update(ENTITY entity);

	public void delete(ENTITY entity);

}
