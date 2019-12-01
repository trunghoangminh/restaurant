package com.trunghoang.restaurant.controllers;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.trunghoang.restaurant.configurations.services.impl.BillServiceImpl;
import com.trunghoang.restaurant.domains.Bill;
import com.trunghoang.restaurant.domains.CustomerOrder;
import com.trunghoang.restaurant.domains.Menu;
import com.trunghoang.restaurant.domains.dtos.BillDTO;
import com.trunghoang.restaurant.repositories.BillRepository;

/**
 * 
 * @author hoang
 *
 */
@RestController
public class BillController {

	private Logger log = LoggerFactory.getLogger(BillController.class);

	@Autowired
	private BillServiceImpl billServiceImpl;

	@Autowired
	private BillRepository billRepository;

	@GetMapping(value = { "/bill" })
	public ResponseEntity<List<BillDTO>> getAll() {
		List<BillDTO> billDTOs = billServiceImpl.findAll();
		log.info(billDTOs.toString());
		return new ResponseEntity<>(billDTOs, HttpStatus.OK);
	}

	@GetMapping(value = { "/bill/{id}" })
	public ResponseEntity<BillDTO> findOne(@PathVariable long id) {
		BillDTO billDTO = billServiceImpl.findById(id);
		return new ResponseEntity<>(billDTO, HttpStatus.OK);
	}

	@GetMapping(value = { "/abc" })
	public ResponseEntity<BillDTO> findOne() {

		Menu menu = new Menu();
		menu.setName("ABC");
		menu.setImageURL("ABC>PNG");
		menu.setPrice(new BigDecimal(10));
		menu.setDescription("ABCABC");
		menu.setAdditionalDetails("123,456,789");

		Bill bill = new Bill();
		bill.setDate(new Date(System.currentTimeMillis()));

		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setQuantity(3);
		customerOrder.setOrderedTime(new Date(System.currentTimeMillis()));
		customerOrder.setBill(bill);

		customerOrder.setMenu(menu);
		Set<CustomerOrder> customerOrders = new HashSet<>();
		customerOrders.add(customerOrder);
		bill.setCustomerOrders(customerOrders);

		billRepository.add(bill);
		// billRepository.findAll();
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
