package com.atif.ansari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atif.ansari.exceptions.DepartmentNotCreatedExceptions;
import com.atif.ansari.exceptions.DepartmentNotFoundExceptions;
import com.atif.ansari.model.DesignationModel;
import com.atif.ansari.service.DesignationService;

@RestController
@RequestMapping("/designaions")
public class DesignationController {

	@Autowired
	DesignationService designationService;

	@GetMapping
	public List<DesignationModel> getAllDesignations() {
		return designationService.getAllDesignatioins();
	}

	@GetMapping("/{id}")
	public ResponseEntity<DesignationModel> getDesignationById(@PathVariable("id") Long id) {
		try {
			DesignationModel designationById = designationService.getDesignationById(id);
			return new ResponseEntity<DesignationModel>(designationById, HttpStatus.OK);
		} catch (Exception e) {
			throw new DepartmentNotFoundExceptions("Designation is not available for Id :" + id);
		}

	}

	@PostMapping("/save")
	public ResponseEntity<String> createDesignation(DesignationModel designationModel) {
		try {
			designationService.createDesignation(designationModel);
			return new ResponseEntity<String>("Designation created successfully", HttpStatus.CREATED);
		} catch (Exception e) {
			throw new DepartmentNotCreatedExceptions("Designaton is not created");
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> update(DesignationModel designationModel, long id) {
		designationService.updateDesignationById(designationModel, id);
		return new ResponseEntity<String>("Designation is Updated successfully", HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDesignationById(@PathVariable("id") Long id) {
		try {
			designationService.deleteDesignationById(id);
			return new ResponseEntity<String>("Designation Deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Designation is Not Available", HttpStatus.NOT_FOUND);
		}

	}
}
