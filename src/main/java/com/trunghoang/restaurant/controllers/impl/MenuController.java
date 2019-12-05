package com.trunghoang.restaurant.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trunghoang.restaurant.controllers.DefaultController;
import com.trunghoang.restaurant.domains.dtos.MenuDTO;
import com.trunghoang.restaurant.services.IService;
import com.trunghoang.restaurant.services.impl.MenuServiceImpl;

@RestController
@RequestMapping("/v1/menu")
public class MenuController extends DefaultController<MenuDTO, IService<MenuDTO>> {

	@Autowired
	private MenuServiceImpl menuService;

	@Override
	public IService<MenuDTO> getService() {
		return menuService;
	}

}
