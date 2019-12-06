package com.trunghoang.restaurant.repositories.impl;

import java.util.List;

import javax.persistence.Query;

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

	// @formatter:off
	private static final String SEARCH = "SELECT menu FROM Menu menu WHERE " + "(name LIKE CONCAT('%', :keyword, '%')) OR "
			+ "(description LIKE CONCAT('%', :keyword, '%')) OR "
			+ "(additionalDetails LIKE CONCAT('%', :keyword, '%'))";

	// @formatter:on

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> search(String keyword) {
		Query query = em.createQuery(SEARCH, Menu.class);
		query.setParameter("keyword", keyword);
		return query.getResultList();
	}
}
