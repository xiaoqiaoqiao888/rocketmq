package com.rails.dao;

import org.springframework.data.repository.CrudRepository;

import com.rails.entity.Product;

public interface ProductDao extends CrudRepository<Product, String> {

}
