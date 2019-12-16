package com.trunghoang.restaurant.domains.dtos;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerOrderDTO implements IdDTO {

	private long id;

	private MenuDTO menu;

	private Timestamp orderedTime;

	private int quantity;

	/**
	 * Get sub total price
	 * 
	 * @return
	 */
	public BigDecimal getSubTotalPrice() {
		BigDecimal price = menu.getPrice();
		BigDecimal bigDecimalQuantity = BigDecimal.valueOf(quantity);
		return price.multiply(bigDecimalQuantity);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((menu == null) ? 0 : menu.hashCode());
		result = prime * result + ((orderedTime == null) ? 0 : orderedTime.hashCode());
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof CustomerOrderDTO) {
			CustomerOrderDTO that = (CustomerOrderDTO) obj;
			return this.id == that.id && this.menu.equals(that.menu) && this.orderedTime.equals(that.orderedTime)
					&& this.quantity == that.quantity;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerOrderDTO [id=");
		builder.append(id);
		if (menu != null) {
			builder.append(", menu=");
			builder.append(menu);
		}
		builder.append(", orderedTime=");
		builder.append(orderedTime);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append("]");
		return builder.toString();
	}
}
