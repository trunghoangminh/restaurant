package com.trunghoang.restaurant.configurations.services;

import org.modelmapper.ModelMapper;

/**
 * 
 * The base class for service layer
 *
 */
public abstract class BaseService {

	protected ModelMapper modelMapper = new ModelMapper();
}
