package com.trunghoang.restaurant.domains.report;

import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BillTotalReport {

	private List<BillReport> billReports;

	private int numberOfBill;

	private BigDecimal grandTotal;
}
