package com.simplilearn.medicare.services;

import java.util.Set;

import com.simplilearn.medicare.entities.Medicine;
import com.simplilearn.medicare.exceptions.MedicineNotFoundException;

public interface MedicineService {
	public Medicine addMedicine(Medicine medicine);
	public Medicine updateMedicine(Medicine medicine) throws MedicineNotFoundException;
	public Set<Medicine> getMedicines(Medicine medicine);
	public Medicine getMedicine(Integer medicineId) throws MedicineNotFoundException;
	public void deleteMedicine(Integer medicineId);
}
