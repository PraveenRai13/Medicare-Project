package com.simplilearn.medicare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.medicare.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
