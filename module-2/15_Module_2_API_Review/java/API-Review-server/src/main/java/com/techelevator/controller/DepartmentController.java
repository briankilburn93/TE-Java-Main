package com.techelevator.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.Department;
import com.techelevator.model.DepartmentDAO;


/**
 * Controller to get the department data via API call
 */

@RestController		// Tell the server there are controllers in this file
public class DepartmentController {
	
	private DepartmentDAO departmentDAO;
	
	// Create a ctr for the controller class that takes a DAO object as a parameter
	//	Spring dependency injection will create an instance of the DAO and pass it to the ctr
	public DepartmentController(DepartmentDAO aDeptDAO) {
		this.departmentDAO = aDeptDAO;		// assign the DAO object passed to our DAO reference
	}
	
	//We want a controller to return all departments in the Department table
	// Is there a DAO method to return all departments? Yes - getAllDepartments() in DepartmentDAO
	// What path do we want the API caller to use to getAllDepartments? "/departments
	
	// identify the method to handle GET requests for that path /departments
	@RequestMapping(path="/departments", method=RequestMethod.GET)
	public List<Department> getAllDepartments() {
		logAPICall("GET for departments");		// Log the API call
		return departmentDAO.getAllDepartments();
	}
	
	// We want a controller to return a specific department in the Department table
	// Is there a DAO method to return a specific department? - getDepartmentById(Long id)
	// What path do we want the API caller to use?
	
	@RequestMapping(path="/departments/{id}", method=RequestMethod.GET)
	public Department getDepartment(@PathVariable Long id) {
		logAPICall("GET for single department");		// Log the API call
		return departmentDAO.getDepartmentById(id);
	}
	
	@RequestMapping(path="/departments/search", method=RequestMethod.GET)
	public List<Department> getDepartmentByName(@RequestParam(value="name", defaultValue="")String nameSearch) {
		logAPICall("GET /departments/search?name=" + nameSearch);		// Log the API call
		return departmentDAO.searchDepartmentsByName(nameSearch);
	}
	
	@RequestMapping(path="/departments", method=RequestMethod.POST)
	public Department addDepartment(@RequestBody Department aDepartment) {
		logAPICall("POST /departments " + aDepartment);		// Log the API call
		return departmentDAO.createDepartment(aDepartment);
	}
	
public void logAPICall(String message) {
	 LocalDateTime now = LocalDateTime.now();
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss.A");
     String timeNow = now.format(formatter);
     System.out.println(timeNow + "-" + message);
 }
}


