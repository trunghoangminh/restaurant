package com.trunghoang.restaurant.controllers.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trunghoang.restaurant.controllers.DefaultController;
import com.trunghoang.restaurant.domains.dtos.BillDTO;
import com.trunghoang.restaurant.domains.dtos.CustomerOrderDTO;
import com.trunghoang.restaurant.domains.dtos.OrderDTO;
import com.trunghoang.restaurant.exceptions.ApplicationException;
import com.trunghoang.restaurant.services.BillService;
import com.trunghoang.restaurant.services.IService;

@RestController
@RequestMapping("/v1/bill")
public class BillController extends DefaultController<BillDTO, IService<BillDTO>> {

	@Autowired
	private BillService billService;

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

		logEvent("Create bill of " + this.getClass());
		BillDTO billDTO = new BillDTO();
		billDTO.setDate(new Timestamp(System.currentTimeMillis()));
		return add(billDTO);
	}

	@PostMapping("/createcustomerorder/{id}")
	public ResponseEntity<Void> createCustomerOder(@PathVariable long id, @RequestBody CustomerOrderDTO customerOrderDTO)
			throws ApplicationException {
		billService.createCustomerOder(id, customerOrderDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/updatecustomerorder")
	public ResponseEntity<Void> updateCustomerOder(@RequestBody OrderDTO orderDTO) throws ApplicationException {
		billService.updateCustomerOrder(orderDTO.getId(), orderDTO.getQuantity(), orderDTO.getDate());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/createcustomerorder/{id}")
	public ResponseEntity<Void> deleteCustomerOder(@PathVariable long id) throws ApplicationException {
		billService.deleteCustomerOrder(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}