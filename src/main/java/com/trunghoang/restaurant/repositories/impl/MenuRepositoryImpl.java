package com.trunghoang.restaurant.repositories.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.trunghoang.restaurant.domains.Menu;
import com.trunghoang.restaurant.repositories.DefaultRepository;
import com.trunghoang.restaurant.repositories.MenuRepository;

/**
 * 
 * Menu repository implementation
 *
 */
@Repository
public class MenuRepositoryImpl extends DefaultRepository<Menu> implements MenuRepository {

	public MenuRepositoryImpl() {
		super(Menu.class);
	}

	@Override
	public void updateInfo(Menu existedEntity, Menu entity) {
		existedEntity.setName(entity.getName());
		existedEntity.setPrice(entity.getPrice());
		existedEntity.setDescription(entity.getDescription());
		existedEntity.setImageURL(entity.getImageURL());
		existedEntity.setAdditionalDetails(entity.getAdditionalDetails());
	}

	@Override
	public List<Menu> search(String title, String description, String additionalDetails) {
		return null;
	}
}
