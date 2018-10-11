package com.rails.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rails.entity.Hotel;

public interface HotelDao extends CrudRepository<Hotel, String> {
	@Query(value = "select * from gt10_hotel_adapter", nativeQuery = true)
	List<Hotel> findByAll();
}
