package com.trunghoang.restaurant.repositories.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trunghoang.restaurant.domains.Bill;
import com.trunghoang.restaurant.repositories.BillRepository;

/**
 * 
 * Bill repository implementation
 *
 */
@Repository
public class BillRepositoryImpl implements BillRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Bill> findAll() {
		return entityManager.createQuery("SELECT bill FROM Bill bill", Bill.class).getResultList();
	}

	@Override
	public Bill findById(long id) {
		return entityManager.find(Bill.class, id);
	}

	@Override
	@Transactional
	public void add(Bill bill) {
		entityManager.persist(bill);
	}

	@Override
	@Transactional
	public void update(Bill bill) {
		Bill existedBill = findById(bill.getId());
		existedBill.setDate(bill.getDate());
		existedBill.setCustomerOrders(bill.getCustomerOrders());
	}

	@Override
	@Transactional
	public void delete(Bill bill) {
		entityManager.remove(findById(bill.getId()));
	}

}
