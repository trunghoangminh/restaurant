package com.trunghoang.restaurant.domains.dtos;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerOrderDTO {

    private long id;

    private BillDTO bill;

    private MenuDTO menu;

    private Date orderedTime;

    private int quantity;

    @Override
    public String toString() {
	return "CustomerOrderDTO [id=" + id + ", orderedTime=" + orderedTime + ", quantity=" + quantity + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (id ^ (id >>> 32));
	result = prime * result + ((orderedTime == null) ? 0 : orderedTime.hashCode());
	result = prime * result + quantity;
	return result;
    }

    @Override
    public boolean equals( Object obj ) {
	if ( this == obj )
	    return true;
	if ( obj == null )
	    return false;
	if ( getClass() != obj.getClass() )
	    return false;
	CustomerOrderDTO other = (CustomerOrderDTO) obj;
	if ( id != other.id )
	    return false;
	if ( orderedTime == null ) {
	    if ( other.orderedTime != null )
		return false;
	} else if ( !orderedTime.equals( other.orderedTime ) )
	    return false;
	if ( quantity != other.quantity )
	    return false;
	return true;
    }

}
