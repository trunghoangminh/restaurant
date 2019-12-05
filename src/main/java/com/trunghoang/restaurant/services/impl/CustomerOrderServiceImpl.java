package com.trunghoang.restaurant.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trunghoang.restaurant.domains.CustomerOrder;
import com.trunghoang.restaurant.domains.dtos.CustomerOrderDTO;
import com.trunghoang.restaurant.domains.mapper.DefaultClassMapper;
import com.trunghoang.restaurant.repositories.IRepository;
import com.trunghoang.restaurant.repositories.impl.CustomerOrderRepositoryImpl;

/**
 * 
 * Customer order service implementation
 */
@Service
public class CustomerOrderServiceImpl
		extends DefaultService<CustomerOrderDTO, CustomerOrder, IRepository<CustomerOrder>> {

	@Autowired
	private CustomerOrderRepositoryImpl customerOrderRepository;

	@Autowired
	private DefaultClassMapper defaultClassMapper;

	@Override
	public IRepository<CustomerOrder> getRepository() {
		return customerOrderRepository;
	}

	@Override
	public CustomerOrderDTO convertToDTO(CustomerOrder entity) {
		return defaultClassMapper.convert(entity, CustomerOrderDTO.class);
	}

	@Override
	public CustomerOrder convertToEntity(CustomerOrderDTO dto) {
		return defaultClassMapper.convert(dto, CustomerOrder.class);
	}

	@Override
	public List<CustomerOrderDTO> convertToDTOList(List<CustomerOrder> entities) {
		return defaultClassMapper.convertToList(entities, CustomerOrderDTO.class);
	}
}
