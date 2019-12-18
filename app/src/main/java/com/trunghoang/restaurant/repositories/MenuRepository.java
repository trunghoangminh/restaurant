package com.trunghoang.restaurant.repositories;

import java.util.List;

import com.trunghoang.restaurant.domains.Menu;

/**
 * 
 * 
 *
 */
public interface MenuRepository extends IRepository<Menu> {
	public List<Menu> search(String keyword);
}
