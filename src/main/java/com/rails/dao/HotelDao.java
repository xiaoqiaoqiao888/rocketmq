package com.rails.dao;

import org.springframework.data.repository.CrudRepository;

import com.rails.entity.Hotel;

public interface HotelDao extends CrudRepository<Hotel, String> {

}
