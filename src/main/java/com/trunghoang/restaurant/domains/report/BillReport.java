package com.trunghoang.restaurant.domains.report;

import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * 
 * This class represent for a bill
 */
@Getter
@Setter
@NoArgsConstructor
public class BillReport {

	private long id;

	private List<OrderInfo> orderInfo;

	private BigDecimal totalPrice;

}
