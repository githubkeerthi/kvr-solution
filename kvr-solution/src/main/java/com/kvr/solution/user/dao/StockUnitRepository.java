package com.kvr.solution.user.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kvr.solution.common.entity.StockUnit;

@Repository
public interface StockUnitRepository extends MongoRepository<StockUnit, Long>{

}
