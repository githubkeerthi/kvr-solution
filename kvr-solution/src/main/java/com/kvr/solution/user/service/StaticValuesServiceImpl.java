package com.kvr.solution.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kvr.solution.common.entity.ParamValue;
import com.kvr.solution.user.dao.StaticValuesRepository;

@Service
public class StaticValuesServiceImpl implements StaticValuesService {

	@Autowired
	private StaticValuesRepository staticValuesRepositroy;
	
	public StaticValuesRepository getStaticValuesRepositroy() {
		return staticValuesRepositroy;
	}

	@Override
	public List<ParamValue> findByParamCode(String paramCode) {
		
		return staticValuesRepositroy.findByParamCode(paramCode).getParamValues();
	}

}
