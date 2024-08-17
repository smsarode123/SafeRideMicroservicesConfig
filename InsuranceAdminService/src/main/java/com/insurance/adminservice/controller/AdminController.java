package com.insurance.adminservice.controller;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.insurance.adminservice.model.Employee;
import com.insurance.adminservice.servicei.AdminServiceI;

@RestController
public class AdminController {
	
	@Autowired AdminServiceI service; 
	
	@DeleteMapping("/deleteEmployee_ById/{employeeId}")
	public ResponseEntity<Employee> deleteProduct(@PathVariable("employeeId") int employeeId)
	{
		
		service.deleteEmployee(employeeId);
		
		ResponseEntity<Employee> response=new ResponseEntity<Employee>( HttpStatus.GONE);
		
		return response;
		
		
	}
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<String> handleObjectNotFoundException(ObjectNotFoundException exception)
	{
		
		System.out.println("exception method");
		
		
		 return new ResponseEntity<String>(exception.toString(), HttpStatus.NOT_FOUND);
		
	}
	
	

}
