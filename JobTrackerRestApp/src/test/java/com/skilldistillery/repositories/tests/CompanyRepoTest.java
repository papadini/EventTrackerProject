package com.skilldistillery.repositories.tests;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.skilldistillery.jobtracker.entities.Company;
import com.skilldistillery.jobtracker.repositories.CompanyRepository;

@RunWith( SpringRunner.class)
@SpringBootTest
class CompanyRepoTest {
	
	@Autowired
	CompanyRepository cRepo;

	@Test
	@DisplayName("testing repo to DB")
	void test() {
		
		Optional<Company> opt = cRepo.findById(1);
		Company comp = opt.get();
		
		assertEquals("Skill Distillery", comp.getName());
	}

}
