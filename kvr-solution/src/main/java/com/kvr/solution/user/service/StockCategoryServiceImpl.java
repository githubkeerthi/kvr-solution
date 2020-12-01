package com.kvr.solution.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kvr.solution.common.dao.SequenceDAO;
import com.kvr.solution.common.entity.StockCategory;
import com.kvr.solution.common.utils.DBConstants;
import com.kvr.solution.user.dao.StockCategoryRepository;

@Service
public class StockCategoryServiceImpl implements StockCategoryService {

	@Autowired
	private StockCategoryRepository stockCategoryRepository;
	
	@Autowired
	private SequenceDAO sequenceDao;
	
	@Override
	public StockCategoryRepository getStockCategoryRepository() {
		return this.stockCategoryRepository;
	}

	@Override
	public StockCategory save(StockCategory stockCategory) {
		stockCategory.setId(sequenceDao.getNextSequenceId(DBConstants.STOCK_CATEGORY_COLLECTION_NAME));
		return stockCategoryRepository.save(stockCategory);
	}

}
