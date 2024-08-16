package com.insurance.adminservice.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.adminservice.exceptions.ObjectNotFoundException;
import com.insurance.adminservice.model.Employee;
import com.insurance.adminservice.repository.AccountDetailsRepository;
import com.insurance.adminservice.repository.EmployeeRepository;
import com.insurance.adminservice.repository.ServiceCenterRepository;
import com.insurance.adminservice.servicei.AdminServiceI;
@Service
public class AdminServiceImpl implements AdminServiceI {
	
	@Autowired private AccountDetailsRepository accuntDetailsRepository;
	
	@Autowired private EmployeeRepository employeeRepository;
	
	@Autowired private ServiceCenterRepository serviceCenterRepository;

	@Override
	public Employee getEmployeeDetailsById(int employeeId) {
		Optional<Employee> opt=employeeRepository.findById(employeeId);
		if(opt.isPresent()){
			System.out.println("opt.get()");
			Employee employeeRef=opt.get();
			return employeeRef;
		} else{
			System.out.println("throw exception");
		    throw new ObjectNotFoundException("Object is not found");
		}
		
	}

	@Override
	public void save(Employee emp) {
		// TODO Auto-generated method stub
		employeeRepository.save(emp);
	}
	
	

}
