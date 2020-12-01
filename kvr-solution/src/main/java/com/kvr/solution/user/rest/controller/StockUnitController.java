package com.kvr.solution.user.rest.controller;

import java.util.List;
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

import com.kvr.solution.common.entity.StockUnit;
import com.kvr.solution.user.service.StockUnitService;

@RestController
@CrossOrigin("*")
public class StockUnitController {

	@Autowired
	private StockUnitService service;

	@RequestMapping(value = "/stockunit/save", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody StockUnit stockUnit) {

		StockUnit stockUnitsDetails = service.save(stockUnit);
		return new ResponseEntity<StockUnit>(stockUnitsDetails, HttpStatus.OK);

	}

	@RequestMapping(value = "/stockunit/update", method = RequestMethod.POST)
	public ResponseEntity<?> update(@RequestBody StockUnit stockUnit) {

		StockUnit stockUnitsDetails = service.getStockUnitRepository().save(stockUnit);
		return new ResponseEntity<StockUnit>(stockUnitsDetails, HttpStatus.OK);

	}

	@GetMapping(value = "/stockunit/getById/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {

		Optional<StockUnit> stockUnitsDetails = service.getStockUnitRepository().findById(id);
		return new ResponseEntity<StockUnit>(stockUnitsDetails.get(), HttpStatus.OK);

	}

	@GetMapping(value = "/stockunit/getAll")
	public ResponseEntity<?> getAll() {

		List<StockUnit> stockUnitsList = service.getStockUnitRepository().findAll();
		return new ResponseEntity<List<StockUnit>>(stockUnitsList, HttpStatus.OK);

	}

	@RequestMapping(value = "/stockunit/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.getStockUnitRepository().deleteById(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);

	}
}
