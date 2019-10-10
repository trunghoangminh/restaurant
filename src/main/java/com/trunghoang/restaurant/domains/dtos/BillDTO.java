package com.trunghoang.restaurant.domains.dtos;

import java.sql.Date;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BillDTO {

    private long id;

    private Date date;

    private Set<CustomerOrderDTO> customerOrders;

    @Override
    public String toString() {
	return "BillDTO [id=" + id + ", date=" + date + ", customerOrders=" + customerOrders + "]";
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
    public boolean equals( Object obj ) {
	if ( this == obj )
	    return true;
	if ( obj == null )
	    return false;
	if ( getClass() != obj.getClass() )
	    return false;
	BillDTO other = (BillDTO) obj;
	if ( customerOrders == null ) {
	    if ( other.customerOrders != null )
		return false;
	} else if ( !customerOrders.equals( other.customerOrders ) )
	    return false;
	if ( date == null ) {
	    if ( other.date != null )
		return false;
	} else if ( !date.equals( other.date ) )
	    return false;
	if ( id != other.id )
	    return false;
	return true;
    }

}
