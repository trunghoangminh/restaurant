package com.trunghoang.restaurant.domains.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.trunghoang.restaurant.domains.Bill;
import com.trunghoang.restaurant.domains.CustomerOrder;
import com.trunghoang.restaurant.domains.Menu;
import com.trunghoang.restaurant.domains.dtos.BillDTO;
import com.trunghoang.restaurant.domains.dtos.CustomerOrderDTO;
import com.trunghoang.restaurant.domains.dtos.MenuDTO;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;

/**
 * 
 * Bill mapper
 *
 */
public class BillMapper implements Mapper {

	private static final String CUSTOMER_ORDERS = "customerOrders";

	@Override
	public void registerClassMap(MapperFactory mapperFactory) {
		mapperFactory.classMap(Bill.class, BillDTO.class).exclude(CUSTOMER_ORDERS).byDefault()
				.customize(new CustomMapper<Bill, BillDTO>() {
					@Override
					public void mapAtoB(Bill a, BillDTO b, MappingContext context) {

						if (a.getCustomerOrders() != null) {
							// Map manually for customerOrder field to void
							// infinity loop(in A has B and in B has A)
							// Convert Customer to CustomerDTO
							Set<CustomerOrderDTO> customerOrders = new HashSet<>();
							for (CustomerOrder customerOrder : a.getCustomerOrders()) {
								CustomerOrderDTO customerOrderDTO = new CustomerOrderDTO();

								// Normal info
								customerOrderDTO.setId(customerOrder.getId());
								customerOrderDTO.setOrderedTime(customerOrder.getOrderedTime());
								customerOrderDTO.setQuantity(customerOrder.getQuantity());

								// Convert Menu to MenuDTO
								Menu menu = customerOrder.getMenu();
								if (menu != null) {
									MenuDTO menuDTO = new MenuDTO();
									menuDTO.setId(menu.getId());
									menuDTO.setDescription(menu.getDescription());

									List<String> additionalDetails = Arrays
											.asList(menu.getAdditionalDetails().split(SEPARATOR));
									menuDTO.setAdditionalDetails(new ArrayList<>(additionalDetails));

									menuDTO.setImageURL(menu.getImageURL());
									menuDTO.setName(menu.getName());
									menuDTO.setPrice(menu.getPrice());
									// Set MenuDTO
									customerOrderDTO.setMenu(menuDTO);
								}

								// Don't include bill to avoid infinity loop
								// customerOrderDTO.setBill( b );

								customerOrders.add(customerOrderDTO);
							}
							b.setCustomerOrders(customerOrders);
						}
					}

					public void mapBtoA(BillDTO b, Bill a, MappingContext context) {
						Set<CustomerOrder> customerOrders = new HashSet<>();

						if (b.getCustomerOrders() != null) {
							for (CustomerOrderDTO customerOrderDTO : b.getCustomerOrders()) {
								CustomerOrder customerOrder = new CustomerOrder();
								customerOrder.setId(customerOrderDTO.getId());
								customerOrder.setQuantity(customerOrderDTO.getQuantity());
								customerOrder.setOrderedTime(customerOrderDTO.getOrderedTime());

								// Convert MenuDTO to Menu
								MenuDTO menuDTO = customerOrderDTO.getMenu();
								if (menuDTO != null) {
									Menu menu = new Menu();
									menu.setId(menuDTO.getId());
									menu.setDescription(menuDTO.getDescription());
									menu.setAdditionalDetails(String.join(SEPARATOR, menuDTO.getAdditionalDetails()));
									menu.setImageURL(menuDTO.getImageURL());
									menu.setName(menuDTO.getName());
									menu.setPrice(menuDTO.getPrice());
									// Set Menu
									customerOrder.setMenu(menu);
								}
								// Don't include bill to avoid infinity loop
								// customerOrder.setBill( a );
								customerOrders.add(customerOrder);
							}
							a.setCustomerOrders(customerOrders);
						}
					}
				}).register();
	}
}
