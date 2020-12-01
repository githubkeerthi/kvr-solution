package com.kvr.solution.user.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.kvr.solution.common.dao.SequenceDAO;
import com.kvr.solution.common.entity.StockGroup;
import com.kvr.solution.common.utils.DBConstants;
import com.kvr.solution.user.dao.StockGroupRepository;

@Service
public class StockGroupServiceImpl implements StockGroupService {

	@Autowired
	private StockGroupRepository stockGroupRepository;
	
	@Autowired
	private SequenceDAO sequenceDao;
	
	@Override
	public StockGroupRepository getStockGroupRepository() {
		return this.stockGroupRepository;
	}

	@Override
	public StockGroup save(StockGroup stockGroup) {
		stockGroup.setId(sequenceDao.getNextSequenceId(DBConstants.STOCK_GROUP_COLLECTION_NAME));
		return stockGroupRepository.save(stockGroup);
	}

	@Override
	public Map<Long, String> getStockGroupNames() {
		List<StockGroup> stockGroupNames = stockGroupRepository.findNameAndId();
		return stockGroupNames.stream().collect(Collectors.toMap(StockGroup::getId, StockGroup::getName));
	}

	@Override
	public boolean isStockGroupExists(String name) {
		List<StockGroup> names = stockGroupRepository.findByName(name);
		if(CollectionUtils.isEmpty(names))
			return false;
		return true;
	}

}
