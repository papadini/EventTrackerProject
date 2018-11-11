package com.skilldistillery.jobtracker.entities;




import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CompanyTest {
	

	private static EntityManagerFactory emf;
	private EntityManager em;

	@BeforeAll
	public static void setupALL() {
		emf = Persistence.createEntityManagerFactory("JobTracker");
	}

	@AfterAll
	public static void tearDownALL() {
		emf.close();
	}

	@BeforeEach
	public void setUpBeforeClass() throws Exception {
		em = emf.createEntityManager();
	}

	@AfterEach
	public void tearDownAfterClass() throws Exception {
		em.close();

	}
	
	@Test
	@DisplayName("testing company connecting to DB")
	void test () {
		Company comp = em.find(Company.class, 1);
		
	
		
		assertEquals("Skill Distillery", comp.getName());
	}
	
	@Test
	@DisplayName("testing company mapped to job")
	void test2 () {
		Company comp = em.find(Company.class, 1);
		
		assertEquals( 1, comp.getJobs().size());
		
		double salary = comp.getJobs().get(0).getSalary();
		assertEquals(25000.00, salary);
		
		
		
	}


}
