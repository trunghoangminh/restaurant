package com.trunghoang.restaurant.domains.dtos;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {

	private long id;
	private int quantity;
	private Timestamp date;
}
