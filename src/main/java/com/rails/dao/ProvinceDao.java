package com.rails.dao;

import org.springframework.data.repository.CrudRepository;

import com.rails.entity.Province;

public interface ProvinceDao extends CrudRepository<Province, String> {

}
