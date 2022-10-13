package gwyehya.employeecruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import gwyehya.employeecruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
