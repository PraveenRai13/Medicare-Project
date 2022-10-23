package com.simplilearn.medicare.services.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.medicare.entities.Medicine;
import com.simplilearn.medicare.exceptions.MedicineNotFoundException;
import com.simplilearn.medicare.repositories.MedicineRepository;
import com.simplilearn.medicare.services.MedicineService;
@Service
public class MedicineServiceImpl implements MedicineService {
	@Autowired
	private MedicineRepository medicineRepository;

	@Override
	public Medicine addMedicine(Medicine medicine) {
		return this.medicineRepository.save(medicine);
	}

	@Override
	public Medicine updateMedicine(Medicine medicine) throws MedicineNotFoundException	{
		
		return this.medicineRepository.save(medicine);
	}

	@Override
	public Set<Medicine> getMedicines(Medicine medicine) {
		return new LinkedHashSet<>(this.medicineRepository.findAll());
	}

	@Override
	public Medicine getMedicine(Integer medicineId) throws MedicineNotFoundException {
		return this.medicineRepository.findById(medicineId).orElseThrow(()->new MedicineNotFoundException("Medicine not found"));
	}

	@Override
	public void deleteMedicine(Integer medicineId) {
		this.medicineRepository.deleteById(medicineId);
	}

}
