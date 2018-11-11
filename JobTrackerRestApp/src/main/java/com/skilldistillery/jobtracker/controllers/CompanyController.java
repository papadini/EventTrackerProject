package com.skilldistillery.jobtracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.jobtracker.entities.Company;
import com.skilldistillery.jobtracker.services.CompanyService;
import com.skilldistillery.jobtracker.services.JobService;

@RestController
@RequestMapping("api")
public class CompanyController {
	
	@Autowired
	JobService js;
	@Autowired
	CompanyService cs;
	
	//INDEX
	@GetMapping("companies")
	public List<Company> index() {
		
		List<Company> comps = cs.listAllComp();
		
		return comps;
	}
	
	//SHOW
	@GetMapping("companies/{id}")
	public Company show(@PathVariable("id") Integer id) {
		
		Company company = cs.findById(id);

		return company;
	}
	
	//CREATE
	@PostMapping("companies")
	public String create( @RequestBody Company company) {
		
		cs.create(company);
		
		return "";
	}
	
	//PATCH
	@PatchMapping("companies/{id}")
	public String patch( @RequestBody Company company, @PathVariable("id") Integer id) {
		
		cs.change(company, id);
		
		
		return "";
	}
	
	//DELETE
	@DeleteMapping("companies/{id}")
	public Boolean delete( @PathVariable("id") Integer id) {
		
		return cs.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("ping")
	public String ping() {
		return "pong";
	}

}
