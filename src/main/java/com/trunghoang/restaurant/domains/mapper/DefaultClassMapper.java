package com.trunghoang.restaurant.domains.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * 
 * Default class mapper
 *
 */
@Component
public class DefaultClassMapper {

	private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

	/**
	 * 
	 * Register mapper
	 */
	@PostConstruct
	private void configure() {

		new BillMapper().registerClassMap(mapperFactory);

		new CustomerOrderMapper().registerClassMap(mapperFactory);

		new MenuMapper().registerClassMap(mapperFactory);
	}

	public <S, D> D convert(S sourceObject, Class<D> destinationClass) {
		return mapperFactory.getMapperFacade().map(sourceObject, destinationClass);
	}

	public <T, S> List<T> convertToList(List<S> sourceObjects, Class<T> destClass) {
		List<T> dtos = new ArrayList<>(sourceObjects.size());

		for (S sourceObject : sourceObjects) {
			dtos.add(convert(sourceObject, destClass));
		}
		return dtos;
	}
}
