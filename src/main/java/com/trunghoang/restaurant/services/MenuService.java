package com.trunghoang.restaurant.services;

import java.util.List;

import com.trunghoang.restaurant.domains.dtos.MenuDTO;

public interface MenuService extends IService<MenuDTO>{
	public List<MenuDTO> search(String title, String description, String additionalDetails);
}
