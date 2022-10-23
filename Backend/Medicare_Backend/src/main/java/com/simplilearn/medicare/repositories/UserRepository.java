package com.simplilearn.medicare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.medicare.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByUsername(String username);

}
