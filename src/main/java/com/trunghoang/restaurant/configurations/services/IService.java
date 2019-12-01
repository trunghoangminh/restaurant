package com.trunghoang.restaurant.configurations.services;

import java.util.List;

/**
 * 
 * <p>
 * This interface is common interface for service layer
 * </p>
 * <p>
 * All specific class of "service layer" must implement this interface
 * </p>
 * <p>
 * {@link E} is specific Object
 * </p>
 * <p>
 * {@link T} is return type. Example: boolean
 * </p>
 * <p>
 * {@link K} is basic data type. Example: int, String
 * </p>
 * 
 * @param <E>
 * @param <T>
 * @param <K>
 */
public interface IService<E, T, K> {

	/**
	 * Get all object {@link E} in database
	 * 
	 * @return
	 */
	public List<E> findAll();

	/**
	 * Find object {@link E} in database base on [k] id
	 * 
	 * @param k
	 * @return
	 */
	public E findById(K k);

	/**
	 * Insert object {@link E} into database
	 * 
	 * @param e
	 * @return
	 */
	public void add(E e);

	/**
	 * Edit some info of object {@link E} in database
	 * 
	 * @param e
	 * @return
	 */
	public void update(E e);

	/**
	 * Remove object {@link E} from database
	 * 
	 * @param e
	 * @return
	 */
	public void delete(E e);
}
