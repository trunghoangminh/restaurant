package com.trunghoang.restaurant.domains.report;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Customer {

	private long billId;

	private long menuId;

	private int quantity;
}
