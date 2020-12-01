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

import com.kvr.solution.common.entity.StockCategory;
import com.kvr.solution.user.service.StockCategoryService;

@RestController
@CrossOrigin("*")
public class StockCategoryController {

	@Autowired
	private StockCategoryService service;
	
	@RequestMapping(value = "/stockcategory/save", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody StockCategory stockCategory) {

		StockCategory stockCategoryDetails = service.save(stockCategory);
		return new ResponseEntity<StockCategory>(stockCategoryDetails, HttpStatus.OK);

	}

	@RequestMapping(value = "/stockcategory/update", method = RequestMethod.POST)
	public ResponseEntity<?> update(@RequestBody StockCategory stockCategory) {

		StockCategory stockCategoryDetails = service.getStockCategoryRepository().save(stockCategory);
		return new ResponseEntity<StockCategory>(stockCategoryDetails, HttpStatus.OK);

	}

	@GetMapping(value = "/stockcategory/getById/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		
		Optional<StockCategory> stockCategoryDetails = service.getStockCategoryRepository().findById(id);
		return new ResponseEntity<StockCategory>(stockCategoryDetails.get(), HttpStatus.OK);

	}

	@GetMapping(value = "/stockcategory/getAll")
	public ResponseEntity<?> getAll() {

		List<StockCategory> stockCategoryList = service.getStockCategoryRepository().findAll();
		return new ResponseEntity<List<StockCategory>>(stockCategoryList, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/stockcategory/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.getStockCategoryRepository().deleteById(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);

	}
}
