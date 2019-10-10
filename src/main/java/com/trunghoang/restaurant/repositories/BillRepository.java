package com.trunghoang.restaurant.repositories;

import java.util.List;

import com.trunghoang.restaurant.domains.Bill;

public interface BillRepository {
    /**
     * Get all object in database
     * 
     * @return
     */
    public List<Bill> findAll();

    /**
     * Find object in database base on k id
     * 
     * @param id
     * @return
     */
    public Bill findById( long id );

    /**
     * Insert object into database
     * 
     * @param bill
     */
    public void add( Bill bill );

    /**
     * Edit some info of object in database
     * 
     * @param bill
     */
    public void update( Bill bill );

    /**
     * Remove bill in database
     * 
     * @param bill
     */
    public void delete( Bill bill );

}
