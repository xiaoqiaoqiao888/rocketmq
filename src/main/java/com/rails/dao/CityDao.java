package com.rails.dao;

import org.springframework.data.repository.CrudRepository;

import com.rails.entity.City;

public interface CityDao extends CrudRepository<City, Integer> {

}
