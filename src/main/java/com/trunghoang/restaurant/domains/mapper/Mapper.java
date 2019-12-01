package com.trunghoang.restaurant.domains.mapper;

import ma.glasnost.orika.MapperFactory;

/**
 * 
 * Interface mapper
 *
 */
public interface Mapper {

	public String SEPARATOR = ",";

	/**
	 * Register mapper
	 * 
	 * @param mapperFactory
	 */
	public void registerClassMap(MapperFactory mapperFactory);

}
