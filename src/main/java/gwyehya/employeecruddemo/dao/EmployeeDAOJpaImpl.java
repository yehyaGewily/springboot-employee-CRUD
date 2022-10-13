package gwyehya.employeecruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gwyehya.employeecruddemo.entity.Employee;
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	
	private EntityManager entityManager;
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		
		this.entityManager = entityManager;
	}
	

	@Override
	public List<Employee> getEmployees() {
		
		Query query=entityManager.createQuery("from Employee");
		List<Employee>theEmpolyees=query.getResultList();
		return theEmpolyees;
	}

	

	@Override
	public Employee getEmployee(int theId) {
		Employee employee=entityManager.find(Employee.class, theId);
		if(employee==null) {
			
		}
		return employee;
	}

	@Override
	public void saveEmployee(Employee theEmployee) {

		entityManager.merge(theEmployee);
		theEmployee.setId(theEmployee.getId());

	}

	@Override
	public void deleteEmployee(int theId) {
		Query query=entityManager.createQuery("delete from Employee where id=:theId");
		query.setParameter("theId", theId);
		query.executeUpdate();

	}

}
