package com.trunghoang.restaurant.domains.dtos;

import java.math.BigDecimal;
import java.util.List;

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
}
