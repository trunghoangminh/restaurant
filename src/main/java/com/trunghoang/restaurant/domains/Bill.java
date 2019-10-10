package com.trunghoang.restaurant.domains;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class represent for bill (receipt) of restaurant
 * 
 *
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table( name = Bill.TABLE_NAME )
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME = "Bill";
    private static final String ID = "Id";
    private static final String DATE = "Date";

    private static final String GENERATOR_NATIVE = "native";

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO, generator = GENERATOR_NATIVE )
    @GenericGenerator( name = GENERATOR_NATIVE, strategy = GENERATOR_NATIVE )
    @Column( name = ID )
    private long id;

    @Column( name = DATE )
    private Date date;

    @OneToMany( mappedBy = "bill", cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    Set<CustomerOrder> customerOrders;
}
