package com.trunghoang.restaurant.repositories.impl;

import org.springframework.stereotype.Repository;

import com.trunghoang.restaurant.domains.Bill;
import com.trunghoang.restaurant.repositories.BillRepository;
import com.trunghoang.restaurant.repositories.DefaultRepository;

/**
 * 
 * 
 * Bill repository implementation
 */
@Repository
public class BillRepositoryImpl extends DefaultRepository<Bill> implements BillRepository {

	public BillRepositoryImpl() {
		super(Bill.class);
	}

	@Override
	public void updateInfo(Bill existedEntity, Bill entity) {
		existedEntity.setDate(entity.getDate());
		existedEntity.setCustomerOrders(entity.getCustomerOrders());
	}
}
