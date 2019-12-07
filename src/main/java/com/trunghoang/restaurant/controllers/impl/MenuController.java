package com.trunghoang.restaurant.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.trunghoang.restaurant.controllers.DefaultController;
import com.trunghoang.restaurant.domains.dtos.MenuDTO;
import com.trunghoang.restaurant.services.IService;
import com.trunghoang.restaurant.services.MenuService;

@RestController
@RequestMapping("/v1/menu")
public class MenuController extends DefaultController<MenuDTO, IService<MenuDTO>> {

	@Autowired
	private MenuService menuService;

	@Override
	public IService<MenuDTO> getService() {
		return menuService;
	}

	@GetMapping(value = "/search")
	@ResponseBody
	public ResponseEntity<List<MenuDTO>> search(@RequestParam(value = "keyword") String keyword) {
		logEvent("Search of " + this.getClass());
		List<MenuDTO> result = menuService.search(keyword);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
