package com.trunghoang.restaurant.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trunghoang.restaurant.domains.Menu;
import com.trunghoang.restaurant.domains.dtos.MenuDTO;
import com.trunghoang.restaurant.domains.mapper.DefaultClassMapper;
import com.trunghoang.restaurant.repositories.IRepository;
import com.trunghoang.restaurant.repositories.impl.MenuRepositoryImpl;
import com.trunghoang.restaurant.services.DefaultService;

/**
 * 
 * Menu service implementation
 *
 */
@Service
public class MenuServiceImpl extends DefaultService<MenuDTO, Menu, IRepository<Menu>> {

	@Autowired
	private MenuRepositoryImpl menuRepository;

	@Autowired
	private DefaultClassMapper defaultClassMapper;

	@Override
	public IRepository<Menu> getRepository() {
		return menuRepository;
	}

	@Override
	public MenuDTO convertToDTO(Menu entity) {
		return defaultClassMapper.convert(entity, MenuDTO.class);
	}

	@Override
	public Menu convertToEntity(MenuDTO dto) {
		return defaultClassMapper.convert(dto, Menu.class);
	}

	@Override
	public List<MenuDTO> convertToDTOs(List<Menu> entities) {
		return defaultClassMapper.convertToList(entities, MenuDTO.class);
	}

}
