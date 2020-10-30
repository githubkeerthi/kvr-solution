package com.kvr.solution.user.service;

import java.util.List;

import com.kvr.solution.common.entity.Company;
import com.kvr.solution.user.dao.CompanyRepositroy;

public interface CompanyService {
	
	public CompanyRepositroy getCompanyRepositroy();
	
	public Company save(Company company);
	
	public Company update(Company company);
	
	public Company findById(Long id);
	
	public  List<Company>  findAll();
	
}
