package com.trunghoang.restaurant.domains.report;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * This class represent for a record in CustomerOrder table
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class OrderInfo {

	private long id;

	private String menu;

	private int quantity;

	private BigDecimal price;

	private Timestamp orderTime;

	private BigDecimal totalPrice;

}
