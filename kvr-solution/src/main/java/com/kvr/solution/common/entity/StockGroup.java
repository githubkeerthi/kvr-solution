package com.kvr.solution.common.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "stockgroup")
public class StockGroup extends AuditFields{

	@Id
	private Long id;
	private String name;
	private String alias;
	private String parentStockGroup;
	private boolean isParentGroup;
}