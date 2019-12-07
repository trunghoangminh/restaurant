package com.trunghoang.restaurant.services.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trunghoang.restaurant.constants.ErrorMessage;
import com.trunghoang.restaurant.domains.Bill;
import com.trunghoang.restaurant.domains.CustomerOrder;
import com.trunghoang.restaurant.domains.Menu;
import com.trunghoang.restaurant.domains.dtos.BillDTO;
import com.trunghoang.restaurant.domains.dtos.CustomerOrderDTO;
import com.trunghoang.restaurant.domains.mapper.DefaultClassMapper;
import com.trunghoang.restaurant.exceptions.ApplicationException;
import com.trunghoang.restaurant.repositories.BillRepository;
import com.trunghoang.restaurant.repositories.CustomerOrderRepository;
import com.trunghoang.restaurant.repositories.MenuRepository;
import com.trunghoang.restaurant.services.BillService;
import com.trunghoang.restaurant.services.DefaultService;

/**
 * 
 * Bill service implementation
 *
 */
@Service
public class BillServiceImpl extends DefaultService<BillDTO, Bill, BillRepository> implements BillService {

	@Autowired
	private BillRepository billRepository;

	@Autowired
	private CustomerOrderRepository customerOrderRepository;

	@Autowired
	private MenuRepository menuRepository;

	@Autowired
	private DefaultClassMapper defaultClassMapper;

	@Override
	public BillRepository getRepository() {
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
	public List<BillDTO> convertToDTOs(List<Bill> entities) {
		return defaultClassMapper.convertToList(entities, BillDTO.class);
	}

	@Transactional
	@Override
	public void createCustomerOder(long id, CustomerOrderDTO customerOrderDTO) throws ApplicationException {
		Bill bill = billRepository.findById(id);
		if (bill == null) {
			throw new ApplicationException("Bill " + ErrorMessage.ENTITY_NOT_FOUND.toString());
		}

		Menu menu = menuRepository.findById(customerOrderDTO.getMenu().getId());
		if (menu == null) {
			throw new ApplicationException("Menu " + ErrorMessage.ENTITY_NOT_FOUND.toString());
		}
		CustomerOrder customerOrder = defaultClassMapper.convert(customerOrderDTO, CustomerOrder.class);
		customerOrder.setBill(bill);
		customerOrder.setMenu(menu);
		customerOrderRepository.add(customerOrder);
	}
	
	@Override
	public void deleteCustomerOrder(long id) throws ApplicationException{
		customerOrderRepository.delete(id);
	}
	
	@Override
	public void updateCustomerOrder(long id, int quantity, Timestamp orderTime ) throws ApplicationException{
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setId(id);
		customerOrder.setOrderedTime(orderTime);
		customerOrder.setQuantity(quantity);
		
		customerOrderRepository.update(customerOrder);
	}
	
}
