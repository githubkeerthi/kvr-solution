package com.kvr.solution.user.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kvr.solution.common.entity.ParamValue;
import com.kvr.solution.user.service.StaticValuesService;

@RestController
@CrossOrigin("http://localhost:4200")
public class StaticValuesController {

	@Autowired
	private StaticValuesService staticValuesService;
	
	@GetMapping(value ="/staticvalue/getByParamCode/{paramCode}")
	public List<ParamValue> getPramValuesByParamCode(@PathVariable String paramCode) {
		return staticValuesService.findByParamCode(paramCode);
	}
}
