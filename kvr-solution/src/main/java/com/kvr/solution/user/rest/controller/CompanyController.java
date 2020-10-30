package com.kvr.solution.user.rest.controller;

import java.util.List;

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

import com.kvr.solution.common.entity.Company;
import com.kvr.solution.user.service.CompanyService;

@RestController
@CrossOrigin("http://localhost:4200")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = "/company/save", method = RequestMethod.POST)
	public ResponseEntity<?> createCompany(@RequestBody Company company) {

		Company companyDetails = companyService.save(company);
		return new ResponseEntity<Company>(companyDetails, HttpStatus.OK);

	}

	@RequestMapping(value = "/company/update", method = RequestMethod.POST)
	public ResponseEntity<?> updateCompany(@RequestBody Company company) {

		Company companyDetails = companyService.update(company);
		return new ResponseEntity<Company>(companyDetails, HttpStatus.OK);

	}

	@GetMapping(value = "/company/getById/{id}")
	public ResponseEntity<?> getCompanyDetailById(@PathVariable Long id) {

		Company companyDetails = companyService.findById(id);
		return new ResponseEntity<Company>(companyDetails, HttpStatus.OK);

	}

	@GetMapping(value = "/company/getAll")
	public ResponseEntity<?> getAllCompanies() {

		List<Company> companiesList = companyService.findAll();
		return new ResponseEntity<List<Company>>(companiesList, HttpStatus.OK);

	}

//	@GetMapping(value = "/company/getAllCompaniesNames")
//	public ResponseEntity<?> getAllCompanyNamesWithIds(){
//		
//	}

}
