package com.kvr.solution.common.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "company")
public class Company extends AuditFields{

	@Transient
	public static final String SEQ_KEY = "company";
	
	@Id
	private Long id;
	
	private Long masterUserId;
	
	private String companyName;
	
	private String ownerFirstName;
	
	private String ownerLastName;
	
	private String ownerName;
	
	private String mailingName;
	
	private String accountMaintainType;
	
	private Address address;
	
	private Long phone;
	
	private String email;
	
	private LocalDate financialYearFrom;
	
	private LocalDate booksBeginingFrom;
	
	private CurrencyInfo currencyInfo;
	
	private String username;
	
	private String password;
	
	public String getOwnerName() {
		return this.ownerFirstName + " "+ this.ownerLastName;
	}
}
