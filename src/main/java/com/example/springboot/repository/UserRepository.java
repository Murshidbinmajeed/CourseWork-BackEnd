package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.User;

import lombok.AllArgsConstructor;

import java.util.Optional;


@AllArgsConstructor
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
//	@Query("""
//			SELECT u FROM user u WHERE u.user_name = :user_name
//			""")
	Optional<User> findUserByUserName(String User);
		
}
