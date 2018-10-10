package com.rails.dao;

import org.springframework.data.repository.CrudRepository;

import com.rails.entity.Zone;

public interface ZoneDao extends CrudRepository<Zone, String> {

}
