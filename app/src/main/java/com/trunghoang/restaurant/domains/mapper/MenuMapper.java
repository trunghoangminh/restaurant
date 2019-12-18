package com.trunghoang.restaurant.domains.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.trunghoang.restaurant.domains.Menu;
import com.trunghoang.restaurant.domains.dtos.MenuDTO;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;

/**
 * 
 * Menu mapper
 *
 */
public class MenuMapper implements Mapper {

	private static final String ADDITIONAL_DETAILS = "additionalDetails";

	@Override
	public void registerClassMap(MapperFactory mapperFactory) {
		mapperFactory.classMap(Menu.class, MenuDTO.class).exclude(ADDITIONAL_DETAILS).byDefault()
				.customize(new CustomMapper<Menu, MenuDTO>() {
					@Override
					public void mapAtoB(Menu a, MenuDTO b, MappingContext context) {
						String[] additionalDetails = a.getAdditionalDetails().split(SEPARATOR);
						b.setAdditionalDetails(new ArrayList<>(Arrays.asList(additionalDetails)));
					}

					@Override
					public void mapBtoA(MenuDTO b, Menu a, MappingContext context) {
						StringBuilder additionalDetails = new StringBuilder();
						List<String> aditionalList = b.getAdditionalDetails();
						for (int i = 0; i < aditionalList.size(); i++) {
							additionalDetails.append(aditionalList.get(i));
							if (i < aditionalList.size() - 1) {
								additionalDetails.append(SEPARATOR);
							}
						}
						a.setAdditionalDetails(additionalDetails.toString());
					}
				}).register();
	}
}
