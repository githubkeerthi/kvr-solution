package com.kvr.solution.user.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kvr.solution.common.entity.StaticValues;

@Repository
public interface StaticValuesRepository extends MongoRepository<StaticValues, Long>{

	public StaticValues findByParamCode(String paramCode);
}
