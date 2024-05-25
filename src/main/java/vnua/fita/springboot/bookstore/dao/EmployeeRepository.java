package vnua.fita.springboot.bookstore.dao;

	import org.springframework.data.jpa.repository.JpaRepository;

import vnua.fita.springboot.bookstore.model.Employee;
	public interface EmployeeRepository extends JpaRepository<Employee, String>{
	}

