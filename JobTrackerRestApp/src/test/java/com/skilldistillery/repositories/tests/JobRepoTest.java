package com.skilldistillery.repositories.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.skilldistillery.jobtracker.entities.Job;
import com.skilldistillery.jobtracker.repositories.JobRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
class JobRepoTest {
	
	@Autowired
	JobRepository jRepo;

	@Test
	@DisplayName("testing repo to DB")
	void test() {
		Optional<Job> opt = jRepo.findById(1);
		Job job = opt.get();
		
		assertEquals("Junior Software Developer", job.getPosition());
		
		
	}

}
