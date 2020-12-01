package com.kvr.solution.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kvr.solution.common.dao.SequenceDAO;
import com.kvr.solution.common.entity.StockUnit;
import com.kvr.solution.common.utils.DBConstants;
import com.kvr.solution.user.dao.StockUnitRepository;

@Service
public class StockUnitServiceImpl implements StockUnitService {

	@Autowired
	private StockUnitRepository stockUnitRepository;
	
	@Autowired
	private SequenceDAO sequenceDao;
	
	@Override
	public StockUnitRepository getStockUnitRepository() {
		return this.stockUnitRepository;
	}

	@Override
	public StockUnit save(StockUnit stockUnit) {
		stockUnit.setId(sequenceDao.getNextSequenceId(DBConstants.STOCK_UNIT_COLLECTION_NAME));
		return stockUnitRepository.save(stockUnit);
	}

}
