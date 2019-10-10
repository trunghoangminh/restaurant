package com.trunghoang.restaurant.domains;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table( name = CustomerOrder.TABLE_NAME )
public class CustomerOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME = "CustomerOrder";
    private static final String ID = "Id";
    private static final String ORDERED_TIME = "OrderedTime";
    private static final String QUANTITY = "Quantity";

    private static final String GENERATOR_NATIVE = "native";

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO, generator = GENERATOR_NATIVE )
    @GenericGenerator( name = GENERATOR_NATIVE, strategy = GENERATOR_NATIVE )
    @Column( name = ID )
    private long id;

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    @JoinColumn( name = "FKBill" )
    private Bill bill;

    @OneToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    @JoinColumn( name = "FKMenu" )
    private Menu menu;

    @Column( name = ORDERED_TIME )
    private Date orderedTime;

    @Column( name = QUANTITY )
    private int quantity;

}
