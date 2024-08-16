package com.insurance.adminservice.servicei;

import com.insurance.adminservice.model.Employee;

public interface AdminServiceI {

	Employee getEmployeeDetailsById(int employeeId);

	void save(Employee emp);

}
