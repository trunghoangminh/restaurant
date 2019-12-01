package com.trunghoang.restaurant.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trunghoang.restaurant.domains.Bill;
import com.trunghoang.restaurant.domains.dtos.BillDTO;
import com.trunghoang.restaurant.domains.mapper.DefaultClassMapper;
import com.trunghoang.restaurant.repositories.BillRepository;
import com.trunghoang.restaurant.services.IService;

/**
 * 
 * Bill service implementation
 *
 */
@Service
public class BillServiceImpl implements IService<BillDTO, Boolean, Long> {

	@Autowired
	private BillRepository billRepository;

	@Autowired
	private DefaultClassMapper defaultClassMapper;

	@Override
	public List<BillDTO> findAll() {
		return defaultClassMapper.convertToList(billRepository.findAll(), BillDTO.class);
	}

	@Override
	public void add(BillDTO e) {
		billRepository.add(defaultClassMapper.convert(e, Bill.class));
	}

	@Override
	public void update(BillDTO e) {
		billRepository.update(defaultClassMapper.convert(e, Bill.class));
	}

	@Override
	public void delete(BillDTO e) {
		billRepository.delete(defaultClassMapper.convert(e, Bill.class));
	}

	@Override
	public BillDTO findById(Long k) {
		return defaultClassMapper.convert(billRepository.findById(k), BillDTO.class);
	}
}
