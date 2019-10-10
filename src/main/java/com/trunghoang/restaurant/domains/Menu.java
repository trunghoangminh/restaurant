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
@Table( name = Menu.TABLE_NAME )
public class Menu implements Serializable {

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
    @GeneratedValue( strategy = GenerationType.AUTO, generator = GENERATOR_NATIVE )
    @GenericGenerator( name = GENERATOR_NATIVE, strategy = GENERATOR_NATIVE )
    @Column( name = ID )
    private long id;

    @Column( name = NAME )
    private String name;

    @Column( name = DESCRIPTION )
    private String description;

    @Column( name = IMAGE_URL )
    private String imageURL;

    @Column( name = PRICE )
    private BigDecimal price;

    @Column( name = ADDITIONAL_DETAILS )
    private String additionalDetails;

}
