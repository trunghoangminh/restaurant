package com.trunghoang.restaurant.domains;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = CustomerOrder.TABLE_NAME)
public class CustomerOrder implements Serializable, IdEntity {

	private static final long serialVersionUID = 1L;

	public static final String TABLE_NAME = "CustomerOrder";
	private static final String ID = "Id";
	private static final String ORDERED_TIME = "OrderedTime";
	private static final String QUANTITY = "Quantity";

	private static final String GENERATOR_NATIVE = "native";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = GENERATOR_NATIVE)
	@GenericGenerator(name = GENERATOR_NATIVE, strategy = GENERATOR_NATIVE)
	@Column(name = ID)
	private long id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "FKBill")
	private Bill bill;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = false)
	@JoinColumn(name = "FKMenu")
	private Menu menu;

	@Column(name = ORDERED_TIME)
	private Timestamp orderedTime;

	@Column(name = QUANTITY)
	private int quantity;

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
		if (obj instanceof CustomerOrder) {
			CustomerOrder that = (CustomerOrder) obj;
			return this.id == that.id && this.menu.equals(that.menu) && this.orderedTime.equals(that.orderedTime)
					&& this.quantity == that.quantity;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerOrder [id=");
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
