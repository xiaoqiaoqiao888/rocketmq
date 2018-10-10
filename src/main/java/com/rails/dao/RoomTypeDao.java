package com.rails.dao;

import org.springframework.data.repository.CrudRepository;

import com.rails.entity.RoomType;

public interface RoomTypeDao extends CrudRepository<RoomType, String> {

}
