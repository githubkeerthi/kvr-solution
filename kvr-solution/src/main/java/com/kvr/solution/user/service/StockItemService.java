package com.kvr.solution.user.service;

import com.kvr.solution.common.entity.StockItem;
import com.kvr.solution.user.dao.StockItemRepository;

public interface StockItemService {

	public StockItemRepository getStockItemRepository();
	
	public StockItem save(StockItem stockItem);
}
