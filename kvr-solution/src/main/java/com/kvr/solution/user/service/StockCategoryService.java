package com.kvr.solution.user.service;

import com.kvr.solution.common.entity.StockCategory;
import com.kvr.solution.user.dao.StockCategoryRepository;

public interface StockCategoryService {

	public StockCategoryRepository getStockCategoryRepository();
	
	public StockCategory save(StockCategory stockCategory);
}
