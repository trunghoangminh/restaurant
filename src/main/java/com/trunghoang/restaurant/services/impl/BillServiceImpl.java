package com.trunghoang.restaurant.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trunghoang.restaurant.domains.Bill;
import com.trunghoang.restaurant.domains.dtos.BillDTO;
import com.trunghoang.restaurant.domains.mapper.DefaultClassMapper;
import com.trunghoang.restaurant.repositories.IRepository;
import com.trunghoang.restaurant.repositories.impl.BillRepositoryImpl;

/**
 * 
 * Bill service implementation
 *
 */
@Service
public class BillServiceImpl extends DefaultService<BillDTO, Bill, IRepository<Bill>> {

	@Autowired
	private BillRepositoryImpl billRepository;

	@Autowired
	private DefaultClassMapper defaultClassMapper;

	@Override
	public IRepository<Bill> getRepository() {
		return billRepository;
	}

	@Override
	public BillDTO convertToDTO(Bill entity) {
		return defaultClassMapper.convert(entity, BillDTO.class);
	}

	@Override
	public Bill convertToEntity(BillDTO dto) {
		return defaultClassMapper.convert(dto, Bill.class);
	}

	@Override
	public List<BillDTO> convertToDTOList(List<Bill> entities) {
		return defaultClassMapper.convertToList(entities, BillDTO.class);
	}
}
