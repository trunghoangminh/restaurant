package com.trunghoang.restaurant.domains.report;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BillOrder {

	private long id;

	private String menu;

	private int quantity;

	private BigDecimal price;

	private Timestamp orderTime;

	private BigDecimal totalPrice;

}
