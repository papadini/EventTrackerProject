package com.skilldistillery.jobtracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobtracker.entities.Company;
import com.skilldistillery.jobtracker.entities.Job;
import com.skilldistillery.jobtracker.repositories.CompanyRepository;
import com.skilldistillery.jobtracker.repositories.JobRepository;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	JobRepository jRepo;

	@Autowired
	CompanyRepository cRepo;

	// FIND BY ID
	@Override
	public Job findById(Integer id) {

		Optional<Job> opt = jRepo.findById(id);
		Job job = opt.get();
		return job;
	}

	// LIST ALL
	@Override
	public List<Job> listAll() {

		List<Job> jobs = jRepo.findAll();

		return jobs;
	}

	// LIST BY COMPANY ID
	@Override
	public List<Job> listByCompId(Integer id) {

		List<Job> jobsByComp = jRepo.findByCompanyId(id);

		return jobsByComp;

	}

	// CREATE
	@Override
	public Job create(Job job) {

		//Optional<Company> opt = cRepo.findById(job.getCompany().getId());
		Optional<Company> opt = cRepo.findById(1);
		Company comp = opt.get();
		job.setCompany(comp);

		Job newJob = jRepo.saveAndFlush(job);

		return newJob;
	}
	
	//CREAT JOB WITH COMPANY ID
	@Override
	public Job createJobWithCompId(Job job, Integer id) {
		
		Optional<Company> opt = cRepo.findById(id);
		Company comp = opt.get();
		
		job.setCompany(comp);
		
		Job newJob = jRepo.saveAndFlush(job);
		
		return newJob;
	}

	// PATCH OR CHANGE
	@Override
	public Job change(Job job, Integer id) {

		Optional<Job> opt = jRepo.findById(id);
		Job managedJob = opt.get();

		if (job.getPosition() != null || job.getPosition() == "") {
			managedJob.setPosition(job.getPosition());
		}
		if (job.getApplied() != null) {
			managedJob.setApplied(job.getApplied());
		}
		if (job.getInterviewNotes() != null || job.getInterviewNotes() == "") {
			managedJob.setInterviewNotes(job.getInterviewNotes());
		}
		if (job.getOfferd() != null) {
			managedJob.setOfferd(job.getOfferd());
		}
		if (job.getCompany() != null) {
			managedJob.setCompany(job.getCompany());
		}

		Job newJob = jRepo.saveAndFlush(managedJob);

		return newJob;
	}

	// DELETE
	@Override
	public Boolean deleteById(Integer id) {

		Boolean deleted = false;
		Optional<Job> opt = jRepo.findById(id);

		if (opt.isPresent()) {
			Job managedJob = opt.get();
			jRepo.delete(managedJob);

			Optional<Job> opt2 = jRepo.findById(id);

			if (!opt2.isPresent()) {
				deleted = true;
			}
		}

		return deleted;
	}

}
