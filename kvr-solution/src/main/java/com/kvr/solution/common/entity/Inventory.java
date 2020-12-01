package com.kvr.solution.common.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "inventory")
public class Inventory extends AuditFields{

	private long quantity;
	private long price; 
	private String unitType;
}
