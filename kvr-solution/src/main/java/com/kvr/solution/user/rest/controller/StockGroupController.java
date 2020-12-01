package com.kvr.solution.user.rest.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kvr.solution.common.entity.StockGroup;
import com.kvr.solution.user.service.StockGroupService;

@RestController
@CrossOrigin("*")
public class StockGroupController {

	@Autowired
	private StockGroupService service;
	
	@RequestMapping(value = "/stockgroup/save", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody StockGroup stockGroup) {

		StockGroup stockGroupDetails = service.save(stockGroup);
		return new ResponseEntity<StockGroup>(stockGroupDetails, HttpStatus.OK);

	}

	@RequestMapping(value = "/stockgroup/update", method = RequestMethod.POST)
	public ResponseEntity<?> update(@RequestBody StockGroup stockGroup) {

		StockGroup stockGroupDetails = service.getStockGroupRepository().save(stockGroup);
		return new ResponseEntity<StockGroup>(stockGroupDetails, HttpStatus.OK);

	}

	@GetMapping(value = "/stockgroup/getById/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		
		Optional<StockGroup> stockGroupDetails = service.getStockGroupRepository().findById(id);
		return new ResponseEntity<StockGroup>(stockGroupDetails.get(), HttpStatus.OK);

	}

	@GetMapping(value = "/stockgroup/getAll")
	public ResponseEntity<?> getAll() {

		List<StockGroup> stockGroupList = service.getStockGroupRepository().findAll();
		return new ResponseEntity<List<StockGroup>>(stockGroupList, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/stockgroup/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.getStockGroupRepository().deleteById(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/stockgroup/stockGroupNames", method = RequestMethod.GET)
	public ResponseEntity<?> stockGroupNames(@PathVariable Long id) {
		Map<Long, String> names = service.getStockGroupNames();
		return new ResponseEntity<Map<Long, String>>(names, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/stockgroup/isStockExists/{name}", method = RequestMethod.GET)
	public ResponseEntity<?> stockGroupNames(@PathVariable String name) {
		Boolean flag = service.isStockGroupExists(name);
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);

	}
}
