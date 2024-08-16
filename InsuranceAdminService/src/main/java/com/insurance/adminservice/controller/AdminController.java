package com.insurance.adminservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.adminservice.exceptions.ObjectNotFoundException;
import com.insurance.adminservice.model.Employee;
import com.insurance.adminservice.servicei.AdminServiceI;

@RestController
public class AdminController {
	
	@Autowired AdminServiceI service; 
	
	@GetMapping("/getEmployeeDetails-ById/{employeeId}")
	public ResponseEntity<Employee> getEmployeeDetailsById(@PathVariable int employeeId)
	{
		Employee employeeRef=service.getEmployeeDetailsById(employeeId);
		System.out.println("get details");
		return new ResponseEntity<Employee>(employeeRef, HttpStatus.FOUND);
	}

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<String> handleObjectNotFoundException(ObjectNotFoundException exception)
	{
		System.out.println("exception method");
		return new ResponseEntity<String>(exception.toString(), HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/post")
	public void save(@RequestBody Employee emp)
	{
		service.save(emp);
	}
}

