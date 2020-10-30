package com.kvr.solution.common.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "user")
@Getter
@Setter
public class User extends AuditFields{
	
	@Transient
	public static final String SEQ_KEY = "user";
	
	@Id
	private Long id;

	private Name name;

	private Long phone;
	
	private String emailId;
	
	private Address address;
	
}
