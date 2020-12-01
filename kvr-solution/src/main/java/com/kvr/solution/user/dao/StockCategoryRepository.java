package com.kvr.solution.user.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kvr.solution.common.entity.StockCategory;

@Repository
public interface StockCategoryRepository extends MongoRepository<StockCategory, Long>{

}
