package com.simplilearn.medicare.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.medicare.entities.Medicine;
import com.simplilearn.medicare.exceptions.MedicineNotFoundException;
import com.simplilearn.medicare.services.MedicineService;

@RestController
@RequestMapping("/medicine")
@CrossOrigin("*")
public class MedicineController {
	@Autowired
	private MedicineService medicineService;
	
	//Add medicines
@PostMapping("/")
public ResponseEntity<Medicine> addMedicine(@RequestBody Medicine medicine){
	Medicine medi=this.medicineService.addMedicine(medicine);
	return ResponseEntity.ok(medi);
}
// Get medicine by id
@GetMapping("/{medicineId}")
public Medicine getMedicine(@PathVariable("medicineId") Integer medicineId) throws MedicineNotFoundException {
	return this.medicineService.getMedicine(medicineId);
}
// Get all medicine
@GetMapping("/")
public ResponseEntity<?> getMedicines(){
	
	return ResponseEntity.ok(this.medicineService.getMedicines(null));
}
//update medicine
@PutMapping("/")
public Medicine updateMedicine(@RequestBody Medicine medicine ) throws MedicineNotFoundException {
	return this.medicineService.updateMedicine(medicine);
}
//delete medicine
	@DeleteMapping("/{medicineId}")
	public void deleteMedicine(@PathVariable("medicineId") Integer medicineId) {
		this.medicineService.deleteMedicine(medicineId);
	}
	
}
