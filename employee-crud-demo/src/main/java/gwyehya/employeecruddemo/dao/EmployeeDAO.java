package gwyehya.employeecruddemo.dao;

import java.util.List;

import gwyehya.employeecruddemo.entity.Employee;

public interface EmployeeDAO {
public List<Employee>getEmployees();
public Employee getEmployee(int theId);
public void saveEmployee(Employee theEmployee);
public void deleteEmployee(int theId);


}
