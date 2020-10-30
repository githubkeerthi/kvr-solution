package com.kvr.solution.common.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

@Getter
public class AuditFields {
	 
	@Setter @CreatedDate
	private LocalDateTime createdDate;
	
	@Setter @CreatedBy
	private String createdBy;
	
	@Setter @LastModifiedDate
	private LocalDateTime lastUpdatedDate;
	
	@Setter @LastModifiedBy
	private String lastUpdateBy;

}
