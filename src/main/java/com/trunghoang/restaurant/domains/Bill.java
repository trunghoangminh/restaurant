package com.trunghoang.restaurant.domains;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class represent for bill (receipt) of restaurant
 * 
 *
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = Bill.TABLE_NAME)
public class Bill implements Serializable, IdEntity {

	private static final long serialVersionUID = 1L;

	public static final String TABLE_NAME = "Bill";
	private static final String ID = "Id";
	private static final String DATE = "Date";

	private static final String GENERATOR_NATIVE = "native";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = GENERATOR_NATIVE)
	@GenericGenerator(name = GENERATOR_NATIVE, strategy = GENERATOR_NATIVE)
	@Column(name = ID)
	private long id;

	@Column(name = DATE)
	private Timestamp date;

	@OneToMany(mappedBy = "bill", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	Set<CustomerOrder> customerOrders;

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
		if (other instanceof Bill) {
			Bill that = (Bill) other;
			return this.id == that.id && this.date.equals(that.date) && this.customerOrders.equals(that.customerOrders);
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bill [id=");
		builder.append(id);
		builder.append(", date=");
		builder.append(date);
		if (customerOrders != null) {
			builder.append(", custommerOders=");
			builder.append(customerOrders);
		}
		builder.append("]");
		return builder.toString();
	}
}
