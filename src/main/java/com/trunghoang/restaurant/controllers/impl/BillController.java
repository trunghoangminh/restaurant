package com.trunghoang.restaurant.controllers.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trunghoang.restaurant.controllers.DefaultController;
import com.trunghoang.restaurant.domains.dtos.BillDTO;
import com.trunghoang.restaurant.services.BillService;
import com.trunghoang.restaurant.services.IService;

@RestController
@RequestMapping("/v1/bill")
public class BillController extends DefaultController<BillDTO, IService<BillDTO>> {

	@Autowired
	private BillService billService;

	@Override
	public IService<BillDTO> getService() {
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
		return super.add(billDTO);
	}
}