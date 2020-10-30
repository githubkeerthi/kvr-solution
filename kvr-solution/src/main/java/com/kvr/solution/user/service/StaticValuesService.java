package com.kvr.solution.user.service;

import java.util.List;

import com.kvr.solution.common.entity.ParamValue;
import com.kvr.solution.user.dao.StaticValuesRepository;

public interface StaticValuesService {

	public StaticValuesRepository getStaticValuesRepositroy();
	
	public List<ParamValue> findByParamCode(String pramCode);

}
