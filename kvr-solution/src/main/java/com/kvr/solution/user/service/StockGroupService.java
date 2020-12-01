package com.kvr.solution.user.service;

import java.util.Map;

import com.kvr.solution.common.entity.StockGroup;
import com.kvr.solution.user.dao.StockGroupRepository;

public interface StockGroupService {

	public StockGroupRepository getStockGroupRepository();
	
	public StockGroup save(StockGroup stockGroup);
	
	public Map<Long, String> getStockGroupNames();
	
	public boolean isStockGroupExists(String name);
}
