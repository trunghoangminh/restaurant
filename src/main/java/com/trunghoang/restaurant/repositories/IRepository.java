package com.trunghoang.restaurant.repositories;

import java.util.List;

import com.trunghoang.restaurant.exceptions.ApplicationException;

/**
 * 
 * Repository interface
 *
 * @param <ENTITY>
 */
public interface IRepository<ENTITY> {

	public List<ENTITY> getAll(int pageNumer, int numberOfRecord);

	public ENTITY findById(long id);

	public void add(ENTITY entity);

	public void update(ENTITY entity);

	public void delete(long id) throws ApplicationException;

}
