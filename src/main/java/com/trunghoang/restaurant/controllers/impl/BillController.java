package com.trunghoang.restaurant.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trunghoang.restaurant.controllers.DefaultController;
import com.trunghoang.restaurant.domains.dtos.BillDTO;
import com.trunghoang.restaurant.services.IService;

@RestController
@RequestMapping("/v1/bill")
public class BillController extends DefaultController<BillDTO, IService<BillDTO>> {

	@Autowired
	@Qualifier("billServiceImpl")
	private IService<BillDTO> billService;

	@Override
	public IService<BillDTO> getService() {
		return billService;
	}

	@Override
	public ResponseEntity<Void> delete(@PathVariable long id) {
		throw new UnsupportedOperationException("Unsupported delete function");
	}
}