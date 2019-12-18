package com.trunghoang.restaurant.services;

import com.trunghoang.restaurant.domains.dtos.CustomerOrderDTO;
import com.trunghoang.restaurant.domains.report.BillReport;
import com.trunghoang.restaurant.exceptions.ApplicationException;

public interface CustomerOrderService extends IService<CustomerOrderDTO> {

	public BillReport getBillReport(long billId);

	public void createCustomerOrder(long billId, long menuId, int quantity) throws ApplicationException;

	public void deleteCustomerOrder(long billId) throws ApplicationException;

	public void updateCustomerOrder(long customerOrderId, int quantity) throws ApplicationException;
}
