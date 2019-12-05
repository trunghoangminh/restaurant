package com.trunghoang.restaurant.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trunghoang.restaurant.controllers.DefaultController;
import com.trunghoang.restaurant.domains.dtos.MenuDTO;
import com.trunghoang.restaurant.services.IService;

@RestController
@RequestMapping("/v1/menu")
public class MenuController extends DefaultController<MenuDTO, IService<MenuDTO>> {

	@Autowired
	@Qualifier("menuServiceImpl")
	private IService<MenuDTO> menuService;

	@Override
	public IService<MenuDTO> getService() {
		return menuService;
	}
}
