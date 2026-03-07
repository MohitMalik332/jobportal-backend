package com.mohit.jobportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohit.jobportal.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByEmail(String email);
	
//	We create only one method findByEmail, because save(), findById(), findAll(), delete() etc are present
//	in JpaRepository and our interface extends that.
}
