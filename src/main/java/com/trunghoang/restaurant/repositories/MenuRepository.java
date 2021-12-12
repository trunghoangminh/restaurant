package com.trunghoang.restaurant.repositories;

import com.trunghoang.restaurant.domains.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 *
 */
public interface MenuRepository extends JpaRepository<Menu, Long> {

	// @formatter:off
    public static final String SEARCH = "SELECT menu FROM Menu menu WHERE "
            + "(name LIKE CONCAT('%', ?1, '%')) OR "
            + "(description LIKE CONCAT('%', ?1, '%')) OR "
            + "(additionalDetails LIKE CONCAT('%', ?1, '%'))";
    // @formatter:on

    @Query(SEARCH)
    public List<Menu> search(String keyword);
}
