package com.trunghoang.restaurant.controllers.impl;

import com.trunghoang.restaurant.controllers.DefaultController;
import com.trunghoang.restaurant.domains.dtos.BillDTO;
import com.trunghoang.restaurant.domains.report.BillReport;
import com.trunghoang.restaurant.domains.report.BillTotalReport;
import com.trunghoang.restaurant.domains.report.Customer;
import com.trunghoang.restaurant.exceptions.ApplicationException;
import com.trunghoang.restaurant.services.BillService;
import com.trunghoang.restaurant.services.CustomerOrderService;
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

import java.sql.Timestamp;

/**
 * 
 * Bill controller
 *
 */
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
	public ResponseEntity<BillDTO> createBill() {
		BillDTO billDTO = new BillDTO();
		billDTO.setDate(new Timestamp(System.currentTimeMillis()));
		return add(billDTO);
	}

	/**
	 * Get report for each bill
	 * 
	 * @return
	 */
	@GetMapping(value = "/order/{billId}")
	public ResponseEntity<BillReport> getBillReport(@PathVariable long billId) {
		BillReport billReport = customerOrderService.getBillReport(billId);
		return new ResponseEntity<>(billReport, HttpStatus.OK);
	}

	/**
	 * Get report for all bill in system
	 * 
	 * @return
	 */
	@GetMapping(value = "/order/total")
	public ResponseEntity<BillTotalReport> getBillTotalReport() {
		return new ResponseEntity<>(billService.checkBillOrder(), HttpStatus.OK);
	}

	/**
	 * Create new customer order
	 * 
	 * @param customer
	 * @return
	 * @throws ApplicationException
	 */
	@PostMapping(value = "/order")
	public ResponseEntity<Void> createCustomerOder(@RequestBody Customer customer) throws ApplicationException {
		customerOrderService.createCustomerOrder(customer.getBillId(), customer.getMenuId(), customer.getQuantity());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Update the customer order
	 * 
	 * @param id
	 * @param quantity
	 * @return
	 * @throws ApplicationException
	 */
	@PutMapping(value = "/order/{id}")
	public ResponseEntity<Void> updateCustomerOder(@PathVariable(name = "id") long customerOrderId,
			@RequestBody int quantity) throws ApplicationException {
		customerOrderService.updateCustomerOrder(customerOrderId, quantity);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Remove customer order
	 * 
	 * @param id
	 * @return
	 * @throws ApplicationException
	 */
	@DeleteMapping(value = "/order/{id}")
	public ResponseEntity<Void> deleteCustomerOder(@PathVariable(name = "id") long customerOrderId)
			throws ApplicationException {
		customerOrderService.deleteCustomerOrder(customerOrderId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}