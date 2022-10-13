package gwyehya.employeecruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gwyehya.employeecruddemo.entity.Employee;
import gwyehya.employeecruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestControl {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee>getEmployees(){
		return employeeService.getEmployees();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId){
		Employee theEmployee= employeeService.getEmployee(employeeId);
		if(theEmployee==null) {
			throw new RuntimeException("Employee not found with this id: "+employeeId);
		}
		
		return theEmployee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee){
		theEmployee.setId(0);
		employeeService.saveEmployee(theEmployee);
		return theEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee){
		
		employeeService.saveEmployee(theEmployee);
		return theEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId){
		Employee theEmployee= employeeService.getEmployee(employeeId);
		if(theEmployee==null){
			throw new RuntimeException("Employee not found with this id: "+employeeId);
		}
		employeeService.deleteEmployee(employeeId);
	return "Employee with id: "+employeeId+" Deleted successfuly!";
	}

}
