package com.trunghoang.restaurant.domains.mapper;

import com.trunghoang.restaurant.domains.Bill;
import com.trunghoang.restaurant.domains.dtos.BillDTO;

import ma.glasnost.orika.MapperFactory;

/**
 * 
 * Bill mapper
 *
 */
public class BillMapper implements Mapper {

	@Override
	public void registerClassMap(MapperFactory mapperFactory) {
		mapperFactory.classMap(Bill.class, BillDTO.class).byDefault().register();
	}
}
