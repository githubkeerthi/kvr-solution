package com.kvr.solution.common.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "staticvalues")
@Setter
@Getter
public class StaticValues {

	@Transient
	public static final String SEQ_KEY = "staticvalues";
	
	@Id
	private Long id;
	
	private String paramCode;
	private List<ParamValue> paramValues;
}
