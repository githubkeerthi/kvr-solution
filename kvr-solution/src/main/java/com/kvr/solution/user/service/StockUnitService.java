package com.kvr.solution.user.service;

import com.kvr.solution.common.entity.StockUnit;
import com.kvr.solution.user.dao.StockUnitRepository;

public interface StockUnitService {

	public StockUnitRepository getStockUnitRepository();
	
	public StockUnit save(StockUnit stockUnit);
}
