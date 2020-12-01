package com.kvr.solution.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kvr.solution.common.dao.SequenceDAO;
import com.kvr.solution.common.entity.StockItem;
import com.kvr.solution.common.utils.DBConstants;
import com.kvr.solution.user.dao.StockItemRepository;

@Service
public class StockItemServiceImpl implements StockItemService {

	@Autowired
	private StockItemRepository stockItemRepository;
	
	@Autowired
	private SequenceDAO sequenceDao;
	
	@Override
	public StockItemRepository getStockItemRepository() {
		return this.stockItemRepository;
	}

	@Override
	public StockItem save(StockItem stockItem) {
		stockItem.setId(sequenceDao.getNextSequenceId(DBConstants.STOCK_ITEM_COLLECTION_NAME));
		return stockItemRepository.save(stockItem);
	}

}
