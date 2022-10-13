package gwyehya.employeecruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gwyehya.employeecruddemo.dao.EmployeeRepository;
import gwyehya.employeecruddemo.entity.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeDAO;
	
	
	@Override
	public List<Employee> getEmployees() {
		
		return employeeDAO.findAll();
	}

	@Override
	public Employee getEmployee(int theId) {
		Optional<Employee> result = employeeDAO.findById(theId);
		Employee theEmployee=null;
		if(result.isPresent()) {
			theEmployee=result.get();
		}
		else {
			throw new RuntimeException("No employee found with this id");
		}
		
		return theEmployee;
	}

	@Override
	public void saveEmployee(Employee theEmployee) {
		employeeDAO.save(theEmployee);
	}

	@Override
	public void deleteEmployee(int theId) {
		employeeDAO.deleteById(theId);
	}

}
