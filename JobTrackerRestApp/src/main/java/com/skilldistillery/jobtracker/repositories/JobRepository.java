package com.skilldistillery.jobtracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobtracker.entities.Job;

public interface  JobRepository extends JpaRepository<Job, Integer>{

	List<Job> findByCompanyId(Integer id);
	//search by keyword, ex: search junior jobs
	//create new job and company
}
