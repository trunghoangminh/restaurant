package com.trunghoang.restaurant.repositories.impl;

import org.springframework.stereotype.Repository;

import com.trunghoang.restaurant.domains.Bill;

/**
 * 
 * 
 * Bill repository implementation
 */
@Repository
public class BillRepositoryImpl extends DefaultRepository<Bill> {

	public BillRepositoryImpl() {
		super(Bill.class);
	}

	@Override
	public void updateInfo(Bill existedEntity, Bill entity) {
		existedEntity.setDate(entity.getDate());
		existedEntity.setCustomerOrders(entity.getCustomerOrders());
	}
}
