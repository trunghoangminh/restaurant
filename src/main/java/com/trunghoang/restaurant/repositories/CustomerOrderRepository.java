package com.trunghoang.restaurant.repositories;

import java.util.List;

import com.trunghoang.restaurant.domains.CustomerOrder;
import com.trunghoang.restaurant.exceptions.ApplicationException;

public interface CustomerOrderRepository extends IRepository<CustomerOrder> {

	public List<CustomerOrder> getBillOrder(long billId);

	public void deleteById(long id) throws ApplicationException;
}
