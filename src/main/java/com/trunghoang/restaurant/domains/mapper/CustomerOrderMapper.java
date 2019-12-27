package com.trunghoang.restaurant.domains.mapper;

import ma.glasnost.orika.MapperFactory;

import com.trunghoang.restaurant.domains.CustomerOrder;
import com.trunghoang.restaurant.domains.dtos.CustomerOrderDTO;

/**
 * 
 * Customer order mapper
 *
 */
public class CustomerOrderMapper implements Mapper {

	@Override
	public void registerClassMap(MapperFactory mapperFactory) {
		mapperFactory.classMap(CustomerOrder.class, CustomerOrderDTO.class).exclude("bill").byDefault().register();
	}
}
