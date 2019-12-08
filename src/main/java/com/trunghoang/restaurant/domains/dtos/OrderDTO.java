package com.trunghoang.restaurant.domains.dtos;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO implements IdDTO {

	private long id;
	private int quantity;
	private Timestamp date;

	@Override
	public String toString() {
		return "OrderDTO [id=" + id + ", quantity=" + quantity + ", date=" + date + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
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
			return this.id == that.id && this.date.equals(that.date) && this.quantity == that.quantity;
		}
		return false;

	}

	public String toStrings() {
		StringBuilder result = new StringBuilder();
		result.append("OrderDTO [id=");
		result.append(id);
		result.append(", quantity=");
		result.append(quantity);
		result.append(", date=");
		result.append(date);
		result.append("]");
		return result.toString();
	}

}
