package com.trunghoang.restaurant.domains.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO implements IdDTO {

	private long id;
	private int quantity;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof BillDTO) {
			OrderDTO that = (OrderDTO) obj;
			return this.id == that.id && this.quantity == that.quantity;
		}
		return false;

	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("OrderDTO [id=");
		result.append(id);
		result.append(", quantity=");
		result.append(quantity);
		result.append("]");
		return result.toString();
	}

}
