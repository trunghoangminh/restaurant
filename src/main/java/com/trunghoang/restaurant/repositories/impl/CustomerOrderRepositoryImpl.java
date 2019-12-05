package com.trunghoang.restaurant.repositories.impl;

import org.springframework.stereotype.Repository;

import com.trunghoang.restaurant.domains.CustomerOrder;
import com.trunghoang.restaurant.repositories.DefaultRepository;

/**
 * 
 * Customer order repository implementation
 *
 */
@Repository
public class CustomerOrderRepositoryImpl extends DefaultRepository<CustomerOrder> {

	public CustomerOrderRepositoryImpl() {
		super(CustomerOrder.class);
	}

	@Override
	public void updateInfo(CustomerOrder existedEntity, CustomerOrder entity) {
		existedEntity.setOrderedTime(entity.getOrderedTime());
		existedEntity.setQuantity(entity.getQuantity());
		existedEntity.setBill(entity.getBill());
		existedEntity.setMenu(entity.getMenu());
	}

}
