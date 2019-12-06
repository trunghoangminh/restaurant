package com.trunghoang.restaurant.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trunghoang.restaurant.controllers.DefaultController;
import com.trunghoang.restaurant.domains.dtos.CustomerOrderDTO;
import com.trunghoang.restaurant.services.CustomerOrderService;
import com.trunghoang.restaurant.services.IService;

@RestController
@RequestMapping("/v1/customerorder")
public class CustomerOrderController extends DefaultController<CustomerOrderDTO, IService<CustomerOrderDTO>> {

	@Autowired
	private CustomerOrderService customerOrderService;

	@Override
	public CustomerOrderService getService() {
		return customerOrderService;
	}

}
