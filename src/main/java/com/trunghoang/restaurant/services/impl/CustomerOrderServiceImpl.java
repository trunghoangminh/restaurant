package com.trunghoang.restaurant.services.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trunghoang.restaurant.constants.ErrorMessage;
import com.trunghoang.restaurant.domains.Bill;
import com.trunghoang.restaurant.domains.CustomerOrder;
import com.trunghoang.restaurant.domains.Menu;
import com.trunghoang.restaurant.domains.dtos.CustomerOrderDTO;
import com.trunghoang.restaurant.domains.mapper.DefaultClassMapper;
import com.trunghoang.restaurant.domains.report.BillOrder;
import com.trunghoang.restaurant.exceptions.ApplicationException;
import com.trunghoang.restaurant.repositories.BillRepository;
import com.trunghoang.restaurant.repositories.CustomerOrderRepository;
import com.trunghoang.restaurant.repositories.MenuRepository;
import com.trunghoang.restaurant.services.CustomerOrderService;
import com.trunghoang.restaurant.services.DefaultService;

/**
 * 
 * Customer order service implementation
 */
@Service
public class CustomerOrderServiceImpl extends DefaultService<CustomerOrderDTO, CustomerOrder, CustomerOrderRepository>
		implements CustomerOrderService {

	@Autowired
	private CustomerOrderRepository customerOrderRepository;

	@Autowired
	private BillRepository billRepository;

	@Autowired
	private MenuRepository menuRepository;

	@Autowired
	private DefaultClassMapper defaultClassMapper;

	@Override
	public CustomerOrderRepository getRepository() {
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
	public List<CustomerOrderDTO> convertToDTOs(List<CustomerOrder> entities) {
		return defaultClassMapper.convertToList(entities, CustomerOrderDTO.class);
	}

	@Override
	public List<BillOrder> getBillOrder(long billId) {

		List<CustomerOrderDTO> customerOrders = convertToDTOs(customerOrderRepository.getBillOrder(billId));
		List<BillOrder> billOrders = new ArrayList<>();

		customerOrders.forEach(order -> {
			BillOrder billOrder = new BillOrder();
			billOrder.setId(order.getId());
			billOrder.setMenu(order.getMenu().getName());
			billOrder.setQuantity(order.getQuantity());
			billOrder.setOrderTime(order.getOrderedTime());
			billOrder.setTotalPrice(order.getSubTotalPrice());
			billOrder.setPrice(order.getMenu().getPrice());
			billOrders.add(billOrder);
		});

		return billOrders;
	}

	@Transactional
	@Override
	public void createCustomerOrder(long billId, long menuId, int quantity) throws ApplicationException {
		Bill bill = billRepository.findById(billId);
		if (bill == null) {
			throw new ApplicationException("Bill id=" + billId + " " + ErrorMessage.ENTITY_NOT_FOUND.toString());
		}

		Menu menu = menuRepository.findById(menuId);
		if (menu == null) {
			throw new ApplicationException("Menu id=" + menuId + " " + ErrorMessage.ENTITY_NOT_FOUND.toString());
		}
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setBill(bill);
		customerOrder.setMenu(menu);
		customerOrder.setOrderedTime(new Timestamp(System.currentTimeMillis()));
		customerOrder.setQuantity(quantity);
		customerOrderRepository.add(customerOrder);
	}

	@Override
	@Transactional
	public void deleteCustomerOrder(long id) throws ApplicationException {
		customerOrderRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void updateCustomerOrder(long customerOrderId, int quantity) throws ApplicationException {
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setId(customerOrderId);
		customerOrder.setQuantity(quantity);

		customerOrderRepository.update(customerOrder);
	}
}
