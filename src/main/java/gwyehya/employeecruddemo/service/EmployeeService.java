package gwyehya.employeecruddemo.service;

import java.util.List;

import gwyehya.employeecruddemo.entity.Employee;

public interface EmployeeService {
	
		public List<Employee>getEmployees();
		public Employee getEmployee(int theId);
		public void saveEmployee(Employee theEmployee);
		public void deleteEmployee(int theId);
}
