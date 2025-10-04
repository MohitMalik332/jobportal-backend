package com.jobportal_backend.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder //(for testing/DTO mapping)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
    @Column(nullable = false)
	private Role role;
	
	//One Employer can have multiple Jobs
	@OneToMany(mappedBy = "employer", cascade = CascadeType.ALL)
	private List<Job> jobs;
	
	// One Candidate can have many Applications
	@OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
	private List<Application> applications;
	
	// One Candidate has one Profile
	@OneToOne(mappedBy = "candidate", cascade = CascadeType.ALL)
	private Profile profile;
	
	// One Employer has one CompanyProfile
	@OneToOne(mappedBy = "employer", cascade = CascadeType.ALL)
	private CompanyProfile companyProfile;
}
