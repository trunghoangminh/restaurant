package com.trunghoang.restaurant.services.impl;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trunghoang.restaurant.domains.Bill;
import com.trunghoang.restaurant.domains.dtos.BillDTO;
import com.trunghoang.restaurant.domains.dtos.CustomerOrderDTO;
import com.trunghoang.restaurant.domains.mapper.DefaultClassMapper;
import com.trunghoang.restaurant.domains.report.OrderInfo;
import com.trunghoang.restaurant.domains.report.BillReport;
import com.trunghoang.restaurant.domains.report.BillTotalReport;
import com.trunghoang.restaurant.repositories.BillRepository;
import com.trunghoang.restaurant.services.BillService;
import com.trunghoang.restaurant.services.DefaultService;

/**
 * 
 * Bill service implementation
 *
 */
@Service
public class BillServiceImpl extends DefaultService<BillDTO, Bill, BillRepository> implements BillService {

	@Autowired
	private BillRepository billRepository;

	@Autowired
	private DefaultClassMapper defaultClassMapper;

	@Override
	public BillRepository getRepository() {
		return billRepository;
	}

	@Override
	public BillDTO convertToDTO(Bill entity) {
		return defaultClassMapper.convert(entity, BillDTO.class);
	}

	@Override
	public Bill convertToEntity(BillDTO dto) {
		return defaultClassMapper.convert(dto, Bill.class);
	}

	@Override
	public List<BillDTO> convertToDTOs(List<Bill> entities) {
		return defaultClassMapper.convertToList(entities, BillDTO.class);
	}

	@Override
	public BillTotalReport checkBillOrder() {
		List<BillDTO> billDTOs = findAll(0, 0);
		BigDecimal grandTotal = BigDecimal.ZERO;
		List<BillReport> billReports = new LinkedList<>();

		for (BillDTO billDTO : billDTOs) {
			grandTotal = grandTotal.add(billDTO.getTotalPrice());
			billReports.add(getBillReport(billDTO));
		}

		BillTotalReport billTotalReport = new BillTotalReport();
		billTotalReport.setGrandTotal(grandTotal);
		billTotalReport.setNumberOfBill(billDTOs.size());
		billTotalReport.setBillReports(billReports);

		return billTotalReport;
	}

	/**
	 * Get bill report
	 * 
	 * @param billDTO
	 * @return
	 */
	private BillReport getBillReport(BillDTO billDTO) {
		BillReport billReport = new BillReport();
		List<OrderInfo> billOrders = new LinkedList<>();

		for (CustomerOrderDTO customerOrderDTO : billDTO.getCustomerOrders()) {
			billOrders.add(getOrderInfo(customerOrderDTO));
		}
		billReport.setId(billDTO.getId());
		billReport.setBillOrders(billOrders);
		billReport.setTotalPrice(billDTO.getTotalPrice());

		return billReport;
	}

	/**
	 * Populate data to BillInfo
	 * 
	 * @param dto
	 * @return
	 */
	public static OrderInfo getOrderInfo(CustomerOrderDTO dto) {
		OrderInfo info = new OrderInfo();
		info.setId(dto.getId());
		info.setMenu(dto.getMenu().getName());
		info.setOrderTime(dto.getOrderedTime());
		info.setPrice(dto.getMenu().getPrice());
		info.setTotalPrice(dto.getSubTotalPrice());
		info.setQuantity(dto.getQuantity());

		return info;
	}

}
