package com.kvr.solution.user.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.kvr.solution.common.entity.StockGroup;

@Repository
public interface StockGroupRepository extends MongoRepository<StockGroup, Long>{

	@Query(value="{}", fields="{name : 1, _id : 1}")
	List<StockGroup> findNameAndId();
	
	List<StockGroup> findByName(String name);
}
