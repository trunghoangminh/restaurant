package com.trunghoang.restaurant.repositories.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.trunghoang.restaurant.constants.ErrorMessage;
import com.trunghoang.restaurant.domains.CustomerOrder;
import com.trunghoang.restaurant.exceptions.ApplicationException;
import com.trunghoang.restaurant.repositories.CustomerOrderRepository;
import com.trunghoang.restaurant.repositories.DefaultRepository;

/**
 * 
 * Customer order repository implementation
 *
 */
@Repository
public class CustomerOrderRepositoryImpl extends DefaultRepository<CustomerOrder> implements CustomerOrderRepository {

	public CustomerOrderRepositoryImpl() {
		super(CustomerOrder.class);
	}

	@Override
	public void updateInfo(CustomerOrder existedEntity, CustomerOrder entity) {
		existedEntity.setQuantity(entity.getQuantity());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerOrder> getBillReport(long billId) {
		Query query = em.createQuery("SELECT order FROM CustomerOrder order WHERE FKBill=:id", CustomerOrder.class);
		query.setParameter("id", billId);
		return query.getResultList();
	}

	@Override
	public void deleteById(long id) throws ApplicationException {
		Query query = em.createQuery("DELETE FROM CustomerOrder WHERE id=:id");
		query.setParameter("id", id);
		if (query.executeUpdate() != 0) {
			throw new ApplicationException(ErrorMessage.CAN_NOT_DELETE_ENTITY.toString());
		}
	}

}
