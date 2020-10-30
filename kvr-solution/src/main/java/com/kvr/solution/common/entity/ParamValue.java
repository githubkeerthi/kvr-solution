package com.kvr.solution.common.entity;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode
public class ParamValue implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Object code;
	
	private String label;
	
	private String desc;
	
	private boolean isActive = true;
	
	public ParamValue() {}
	
	public ParamValue(Object code) {
		this(code, null, null);
	}
	
	public ParamValue(Object code, String label) {
		this(code, label, null);
	}

	public ParamValue(Object code, String label, String desc) {
		this.code = code;
        setLabel(label);
        setDesc(desc);
	}
}
