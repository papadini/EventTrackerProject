package com.skilldistillery.jobtracker.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	

	private String position;
	
	private Boolean applied;
	
	@Column(name="interview_notes")
	private String interviewNotes;
	
	private Double salary;
	
	
	@Column(name="job_offer")
	private Boolean offerd;
	
	@CreationTimestamp
	private Date created;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name= "company_id" )
	private Company company;
	
	
	
	//GETTERS AND SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Boolean getApplied() {
		return applied;
	}

	public void setApplied(Boolean applied) {
		this.applied = applied;
	}

	public String getInterviewNotes() {
		return interviewNotes;
	}

	public void setInterviewNotes(String interviewNotes) {
		this.interviewNotes = interviewNotes;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Boolean getOfferd() {
		return offerd;
	}

	public void setOfferd(Boolean offerd) {
		this.offerd = offerd;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	
	// HASH CODE AND EQUALS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Job other = (Job) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	// TO STRING
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Job [id=").append(id).append(", position=").append(position).append(", applied=")
				.append(applied).append(", interviewNotes=").append(interviewNotes).append(", salary=").append(salary)
				.append(", offerd=").append(offerd).append(", created=").append(created).append(", company=")
				.append(company).append("]");
		return builder.toString();
	}
	
	
	// CONTRUCTOR WITH FIELDS
	public Job(String position, Boolean applied, String interviewNotes, Double salary, Boolean offerd, Date created,
			Company company) {
		super();
		this.position = position;
		this.applied = applied;
		this.interviewNotes = interviewNotes;
		this.salary = salary;
		this.offerd = offerd;
		this.created = created;
		this.company = company;
	}
	
	
	// NO ARG
	public Job () {}
	
	
}
	