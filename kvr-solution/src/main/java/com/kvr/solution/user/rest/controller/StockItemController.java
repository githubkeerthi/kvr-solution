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

import com.kvr.solution.common.entity.StockItem;
import com.kvr.solution.user.service.StockItemService;

@RestController
@CrossOrigin("*")
public class StockItemController {

	@Autowired
	private StockItemService service;

	@RequestMapping(value = "/stockitem/save", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody StockItem stockItem) {

		StockItem stockItemsDetails = service.save(stockItem);
		return new ResponseEntity<StockItem>(stockItemsDetails, HttpStatus.OK);

	}

	@RequestMapping(value = "/stockitem/update", method = RequestMethod.POST)
	public ResponseEntity<?> update(@RequestBody StockItem stockItem) {

		StockItem stockItemsDetails = service.getStockItemRepository().save(stockItem);
		return new ResponseEntity<StockItem>(stockItemsDetails, HttpStatus.OK);

	}

	@GetMapping(value = "/stockitem/getById/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {

		Optional<StockItem> stockItemsDetails = service.getStockItemRepository().findById(id);
		return new ResponseEntity<StockItem>(stockItemsDetails.get(), HttpStatus.OK);

	}

	@GetMapping(value = "/stockitem/getAll")
	public ResponseEntity<?> getAll() {

		List<StockItem> stockItemsList = service.getStockItemRepository().findAll();
		return new ResponseEntity<List<StockItem>>(stockItemsList, HttpStatus.OK);

	}

	@RequestMapping(value = "/stockitem/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.getStockItemRepository().deleteById(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);

	}
}
