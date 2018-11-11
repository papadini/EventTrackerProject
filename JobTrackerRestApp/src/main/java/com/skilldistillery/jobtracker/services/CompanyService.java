package com.skilldistillery.jobtracker.services;

import java.util.List;

import com.skilldistillery.jobtracker.entities.Company;

public interface CompanyService {
	Company findById( Integer id);
	List<Company> listAllComp();
	Company create(Company company);
	Company change(Company company, Integer id);
	Boolean deleteById(Integer id);

}
