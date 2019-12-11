package com.trunghoang.restaurant.services;

import java.util.List;

import com.trunghoang.restaurant.domains.dtos.CustomerOrderDTO;
import com.trunghoang.restaurant.domains.report.BillOrder;
import com.trunghoang.restaurant.exceptions.ApplicationException;

public interface CustomerOrderService extends IService<CustomerOrderDTO> {

	public List<BillOrder> getBillOrder(long billId);

	public void createCustomerOrder(long billId, long menuId, int quantity) throws ApplicationException;

	public void deleteCustomerOrder(long billId) throws ApplicationException;

	public void updateCustomerOrder(long customerOrderId, int quantity) throws ApplicationException;
}
