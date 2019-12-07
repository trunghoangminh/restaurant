package com.trunghoang.restaurant.services;

import java.sql.Timestamp;

import com.trunghoang.restaurant.domains.dtos.BillDTO;
import com.trunghoang.restaurant.domains.dtos.CustomerOrderDTO;
import com.trunghoang.restaurant.exceptions.ApplicationException;

public interface BillService extends IService<BillDTO> {

	public void createCustomerOder(long id, CustomerOrderDTO customerOrderDTO) throws ApplicationException;
	
	public void deleteCustomerOrder(long id) throws ApplicationException;
	
	public void updateCustomerOrder(long id, int quantity, Timestamp orderTime ) throws ApplicationException;
}
