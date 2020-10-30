package com.kvr.solution.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kvr.solution.common.dao.SequenceDAO;
import com.kvr.solution.common.entity.Company;
import com.kvr.solution.user.dao.CompanyRepositroy;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyRepositroy companyRepositroy;
	
	@Autowired
	private SequenceDAO sequenceDao;
	
	
	public CompanyRepositroy getCompanyRepositroy() {
		return companyRepositroy;
	}

	@Override
	public Company save(Company company) {
		company.setId(sequenceDao.getNextSequenceId(Company.SEQ_KEY));
		return companyRepositroy.save(company);
	}

	@Override
	public Company update(Company company) {
		return companyRepositroy.save(company);
	}
	
	@Override
	public Company findById(Long id) {
		return companyRepositroy.findById(id).get();
	}

	@Override
	public List<Company> findAll() {
		// TODO Auto-generated method stub
		return companyRepositroy.findAll();
	}
}
