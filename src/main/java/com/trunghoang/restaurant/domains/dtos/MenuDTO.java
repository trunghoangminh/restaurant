package com.trunghoang.restaurant.domains.dtos;

import java.math.BigDecimal;
import java.util.List;

import com.trunghoang.restaurant.domains.Menu;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MenuDTO {

	private long id;

	private String name;

	private String description;

	private String imageURL;

	private BigDecimal price;

	private List<String> additionalDetails;

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
		if (obj instanceof MenuDTO) {
			MenuDTO that = (MenuDTO) obj;
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
