package com.trunghoang.restaurant.repositories;

import com.trunghoang.restaurant.domains.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {

	@Query("SELECT order FROM CustomerOrder order WHERE FKBill=?1")
	public List<CustomerOrder> getBillReport(long billId);

	public void deleteById(long id);
}
