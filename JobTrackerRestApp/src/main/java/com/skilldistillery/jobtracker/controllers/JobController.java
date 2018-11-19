package com.skilldistillery.jobtracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.jobtracker.entities.Job;
import com.skilldistillery.jobtracker.services.CompanyService;
import com.skilldistillery.jobtracker.services.JobService;

@RestController
@RequestMapping("api")
public class JobController {
	
	@Autowired
	JobService js;
	@Autowired
	CompanyService cs;
	
	//INDEX
		@GetMapping("jobs")
		public List<Job> index() {
			
			List<Job> jobs = js.listAll();
			
			return jobs;
		}
		
		//SHOW
		@GetMapping("jobs/{id}")
		public Job show(@PathVariable("id") Integer id) {
			
			Job job = js.findById(id);

			return job;
		}
		
		//SHOW BY COMPANY ID
		@GetMapping("jobs/companies/{id}")
		public List<Job> indexByCompId( @PathVariable("id") Integer id){
			
			List<Job> jobsByComp = js.listByCompId(id);
			
			return jobsByComp;
		}
		
		//CREATE JOB 
		@PostMapping("jobs")
		public String createJobAndComp( @RequestBody Job job, HttpServletResponse res) {
			
			Job newJob = js.create(job);
			String responseBody = "" +  newJob.getId();
			
			return responseBody;
		}
		//CREATE JOB WITH COMPANY ID
		@PostMapping("companies/{id}/jobs")
		public String createJob( @RequestBody Job job, @PathVariable("id") Integer id) {
			
			Job newJob = js.createJobWithCompId(job, id);
			String responseBody = "" +  newJob.getId();
			
			return responseBody;
		}
		
		//PATCH
		@PatchMapping("jobs/{id}")
		public String patch( @RequestBody Job job, @PathVariable("id") Integer id) {
			
			js.change(job, id);
			
			
			return "";
		}
		
		//DELETE
		@DeleteMapping("jobs/{id}")
		public Boolean delete( @PathVariable("id") Integer id) {
			
			return js.deleteById(id);
		}

}
