package com.trunghoang.restaurant.repositories;

import com.trunghoang.restaurant.domains.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {

}
