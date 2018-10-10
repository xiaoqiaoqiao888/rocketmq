package com.rails.dao;

import org.springframework.data.repository.CrudRepository;

import com.rails.entity.Price;

public interface PriceDao extends CrudRepository<Price, String> {

}
