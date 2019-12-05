package com.trunghoang.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trunghoang.restaurant.domains.dtos.BillDTO;
import com.trunghoang.restaurant.services.IService;
import com.trunghoang.restaurant.services.impl.BillServiceImpl;

@RestController
@RequestMapping("/v1/bill")
public class BillController extends DefaultController<BillDTO, IService<BillDTO>> {

	@Autowired
	private BillServiceImpl billService;

	@Override
	public IService<BillDTO> getService() {
		return billService;
	}
}
