package com.rails.dao;

import org.springframework.data.repository.CrudRepository;

import com.rails.entity.BasePrice;

public interface BasePriceDao extends CrudRepository<BasePrice, String> {
	// @Query("")
	// List<BasePrice> findAll();
}
