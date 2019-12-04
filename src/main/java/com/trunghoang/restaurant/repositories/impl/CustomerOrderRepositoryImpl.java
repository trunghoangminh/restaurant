package com.trunghoang.restaurant.repositories.impl;

import com.trunghoang.restaurant.domains.CustomerOrder;

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
