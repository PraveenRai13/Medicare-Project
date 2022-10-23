package com.simplilearn.medicare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.medicare.entities.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Integer>{

}
