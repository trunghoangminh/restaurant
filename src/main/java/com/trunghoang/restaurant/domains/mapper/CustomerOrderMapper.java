package com.trunghoang.restaurant.domains.mapper;

import com.trunghoang.restaurant.domains.Bill;
import com.trunghoang.restaurant.domains.CustomerOrder;
import com.trunghoang.restaurant.domains.dtos.BillDTO;
import com.trunghoang.restaurant.domains.dtos.CustomerOrderDTO;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;

/**
 * 
 * Customer order mapper
 *
 */
public class CustomerOrderMapper implements Mapper {

    @Override
    public void registerClassMap( MapperFactory mapperFactory ) {
	mapperFactory.classMap( CustomerOrder.class, CustomerOrderDTO.class ).exclude( "bill" ).byDefault().customize( new CustomMapper<CustomerOrder, CustomerOrderDTO>() {

	    @Override
	    public void mapAtoB( CustomerOrder a, CustomerOrderDTO b, MappingContext context ) {
		Bill bill = a.getBill();
		BillDTO billDTO = new BillDTO();
		billDTO.setId( bill.getId() );
		billDTO.setDate( bill.getDate() );

		//		for ( CustomerOrder customerOrder : a.getBill().getCustomerOrders() ) {
		//		    billDTO.setCustomerOrders( customerOrders );
		//		}

		b.setBill( billDTO );
	    }

	    @Override
	    public void mapBtoA( CustomerOrderDTO b, CustomerOrder a, MappingContext context ) {
	    }
	} ).register();
    }
}
