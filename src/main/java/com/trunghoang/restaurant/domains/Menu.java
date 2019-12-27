package com.trunghoang.restaurant.domains;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * This class represent for menu of restaurant
 *
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = Menu.TABLE_NAME)
public class Menu implements Serializable, IdEntity {

	private static final long serialVersionUID = 1L;

	public static final String TABLE_NAME = "Menu";
	private static final String ID = "Id";
	private static final String NAME = "Name";
	private static final String DESCRIPTION = "Description";
	private static final String IMAGE_URL = "ImageURL";
	private static final String PRICE = "Price";
	private static final String ADDITIONAL_DETAILS = "AdditionalDetails";

	private static final String GENERATOR_NATIVE = "native";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = GENERATOR_NATIVE)
	@GenericGenerator(name = GENERATOR_NATIVE, strategy = GENERATOR_NATIVE)
	@Column(name = ID)
	private long id;

	@Column(name = NAME)
	private String name;

	@Column(name = DESCRIPTION)
	private String description;

	@Column(name = IMAGE_URL)
	private String imageURL;

	@Column(name = PRICE)
	private BigDecimal price;

	@Column(name = ADDITIONAL_DETAILS)
	private String additionalDetails;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((additionalDetails == null) ? 0 : additionalDetails.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((imageURL == null) ? 0 : imageURL.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof Menu) {
			Menu that = (Menu) obj;
			return this.id == that.id && this.name.equals(that.name) && this.description.equals(that.description)
					&& this.imageURL.equals(that.imageURL) && this.price.equals(that.price)
					&& this.additionalDetails.equals(this.additionalDetails);
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Menu [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", imageURL=");
		builder.append(", price=");
		builder.append(price);
		builder.append(", additionalDetails=");
		builder.append(additionalDetails);
		return builder.toString();
	}
}
