package com.jobportal_backend.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "jobs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(length = 1000)
	private String description;
	
	@Column(nullable = false)
	private String skills; // We will write comma separated skills
	
	private String location;
	
	private String salarayRange;
	
	private String experience;
	
	private LocalDate postedDate;
	
	// Many Jobs belong to one Employer
	@ManyToOne
	@JoinColumn(name = "employer_id", nullable = false)
	private User employer;
	
	// One Job has many Applications
	@OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
	private List<Application> application;
	
	
	
}
