package com.skilldistillery.jobtracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobtracker.entities.Company;
import com.skilldistillery.jobtracker.repositories.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository cRepo;

	// FIND BY ID
	@Override
	public Company findById(Integer id) {

		Optional<Company> opt = cRepo.findById(id);
		Company comp = opt.get();
		return comp;
	}

	// LIST ALL
	@Override
	public List<Company> listAllComp() {

		List<Company> comps = cRepo.findAll();

		return comps;
	}

	//CREATE
	@Override
	public Company create(Company company) {

		Company newComp = cRepo.saveAndFlush(company);

		return newComp;
	}
	
	//PATCH OR CHANGE
	@Override
	public Company change(Company company, Integer id) {

		Optional<Company> opt = cRepo.findById(id);
		Company managedComp = opt.get();

		if (company.getName() != null || company.getName() == "") {
			managedComp.setName(company.getName());
		}
		if (company.getDescription() != null || company.getDescription() == "") {
			managedComp.setDescription(company.getDescription());
		}
		if (company.getBenefits() != null || company.getBenefits() == "") {
			managedComp.setBenefits(company.getBenefits());
		}
		if (company.getAddress() != null || company.getAddress().equals("")) {
			managedComp.setAddress(company.getAddress());
		}
		if (company.getPhoneNumber() != null || company.getPhoneNumber() == "") {
			managedComp.setPhoneNumber(company.getPhoneNumber());
		}

		Company newComp = cRepo.saveAndFlush(managedComp);

		return newComp;
	}

	//DELETE
	@Override
	public Boolean deleteById(Integer id) {

		Boolean deleted = false;
		Optional<Company> opt = cRepo.findById(id);

		if (opt.isPresent()) {
			Company managedComp = opt.get();
			cRepo.delete(managedComp);
			
			Optional<Company> opt2 = cRepo.findById(id);
			
			if( ! opt2.isPresent() ) {
				deleted = true;
			}
		}

		return deleted;
	}

}
