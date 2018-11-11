package com.skilldistillery.jobtracker.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JobTest {

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
	@DisplayName("testing database connection")
	void test() {
		
		Job job = em.find(Job.class, 1);
		
		assertEquals(1, job.getCompany());
		
	}

}
