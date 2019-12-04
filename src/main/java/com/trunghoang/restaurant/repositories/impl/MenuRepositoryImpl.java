package com.trunghoang.restaurant.repositories.impl;

import org.springframework.stereotype.Repository;

import com.trunghoang.restaurant.domains.Menu;

/**
 * 
 * 
 *
 */
@Repository
public class MenuRepositoryImpl extends DefaultRepository<Menu> {

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
}
