package com.trunghoang.restaurant.controllers.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trunghoang.restaurant.controllers.DefaultController;
import com.trunghoang.restaurant.domains.dtos.BillDTO;
import com.trunghoang.restaurant.domains.report.BillOrder;
import com.trunghoang.restaurant.domains.report.Customer;
import com.trunghoang.restaurant.exceptions.ApplicationException;
import com.trunghoang.restaurant.services.BillService;
import com.trunghoang.restaurant.services.CustomerOrderService;

@RestController
@RequestMapping("/v1/bill")
public class BillController extends DefaultController<BillDTO, BillService> {

	@Autowired
	private BillService billService;

	@Autowired
	private CustomerOrderService customerOrderService;

	@Override
	public BillService getService() {
		return billService;
	}

	@Override
	public ResponseEntity<Void> delete(@PathVariable long id) {
		throw new UnsupportedOperationException("Unsupported delete function");
	}

	/**
	 * Create bill
	 * 
	 * @return
	 */
	@PostMapping(value = "/create")
	public ResponseEntity<Void> createBill() {
		BillDTO billDTO = new BillDTO();
		billDTO.setDate(new Timestamp(System.currentTimeMillis()));
		return add(billDTO);
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping(value = "/order/{billId}")
	public ResponseEntity<List<BillOrder>> billOrder(@PathVariable long billId) {
		List<BillOrder> billOrders = customerOrderService.getBillOrder(billId);
		return new ResponseEntity<>(billOrders, HttpStatus.OK);
	}

	/**
	 * 
	 * @param customer
	 * @return
	 * @throws ApplicationException
	 */
	@PostMapping("/order")
	public ResponseEntity<Void> createCustomerOder(@RequestBody Customer customer) throws ApplicationException {
		customerOrderService.createCustomerOrder(customer.getBillId(), customer.getMenuId(), customer.getQuantity());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @param quantity
	 * @return
	 * @throws ApplicationException
	 */
	@PutMapping("/order/{id}/{quantity}")
	public ResponseEntity<Void> updateCustomerOder(@PathVariable long id, @PathVariable int quantity)
			throws ApplicationException {
		customerOrderService.updateCustomerOrder(id, quantity);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws ApplicationException
	 */
	@DeleteMapping("/order/{id}")
	public ResponseEntity<Void> deleteCustomerOder(@PathVariable long id) throws ApplicationException {
		customerOrderService.deleteCustomerOrder(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}