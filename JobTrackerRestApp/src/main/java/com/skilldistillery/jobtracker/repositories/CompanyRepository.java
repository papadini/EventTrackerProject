package com.skilldistillery.jobtracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobtracker.entities.Company;
import com.skilldistillery.jobtracker.entities.Job;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
	

}
