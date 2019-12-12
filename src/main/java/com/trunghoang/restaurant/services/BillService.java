package com.trunghoang.restaurant.services;

import com.trunghoang.restaurant.domains.dtos.BillDTO;
import com.trunghoang.restaurant.domains.report.BillTotalReport;

public interface BillService extends IService<BillDTO> {

	public BillTotalReport checkBillOrder();

}
