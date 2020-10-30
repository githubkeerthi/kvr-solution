package com.kvr.solution.user.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kvr.solution.jwt.security.JwtUserDetails;

@Repository
public interface MasterUserRepository extends MongoRepository<JwtUserDetails, Long>{

	public JwtUserDetails findByUsername(String username);
}
