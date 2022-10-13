package gwyehya.employeecruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import gwyehya.employeecruddemo.entity.Employee;
@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManger;
	@Override
	public List<Employee>getEmployees() {
		Session session=entityManger.unwrap(Session.class);
		Query<Employee>query=session.createQuery("from Employee",Employee.class);
		List<Employee> employees=query.getResultList();

		return employees;
	}
	@Override
	public Employee getEmployee(int theId) {
		Session session=entityManger.unwrap(Session.class);
		Employee theEmployee=session.get(Employee.class, theId);
		return theEmployee;
		}
	@Override
	public void saveEmployee(Employee theEmployee) {
		Session session=entityManger.unwrap(Session.class);
		session.saveOrUpdate(theEmployee);
	}
	@Override
	public void deleteEmployee(int theId) {
		Session session=entityManger.unwrap(Session.class);
		Query query=session.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", theId);
		query.executeUpdate();
	}

}
