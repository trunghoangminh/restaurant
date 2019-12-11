package com.trunghoang.restaurant.domains.dtos;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BillDTO implements IdDTO {

	private long id;

	private Timestamp date;

	private Set<CustomerOrderDTO> customerOrders;

	/**
	 * Get total price
	 * 
	 * @return
	 */
	public BigDecimal getTotalPrice() {
		BigDecimal total = BigDecimal.ZERO;
		customerOrders.forEach(e -> total.add(e.getSubTotalPrice()));
		return total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerOrders == null) ? 0 : customerOrders.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		if (other instanceof BillDTO) {
			BillDTO that = (BillDTO) other;
			return this.id == that.id && this.date.equals(that.date) && this.customerOrders.equals(that.customerOrders);
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BillDTO [id=");
		builder.append(id);
		builder.append(", date=");
		builder.append(date);
		builder.append(", custommerOders,");
		if (customerOrders != null) {
			builder.append(customerOrders);
		}
		builder.append("]");
		return builder.toString();
	}

}
