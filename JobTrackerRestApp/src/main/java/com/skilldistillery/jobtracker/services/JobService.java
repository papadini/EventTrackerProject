package com.skilldistillery.jobtracker.services;

import java.util.List;

import com.skilldistillery.jobtracker.entities.Job;

public interface JobService {
	Job findById( Integer id);
	List<Job> listAll();
	List<Job> listByCompId(Integer id);
	Job createJobWithCompId(Job job, Integer id);
	Job create( Job job);
	Job change( Job job, Integer id);
	Boolean deleteById( Integer id);

}
