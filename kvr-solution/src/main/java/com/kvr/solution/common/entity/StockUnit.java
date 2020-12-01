package com.kvr.solution.common.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "stockunit")
public class StockUnit extends AuditFields{

	@Id
	private Long id;
	private String name;
	private String formalName;
	private int numberOfDecimals;
}
