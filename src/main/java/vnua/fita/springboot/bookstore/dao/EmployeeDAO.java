package vnua.fita.springboot.bookstore.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;
import vnua.fita.springboot.bookstore.model.Employee;

@Repository
@Transactional
public class EmployeeDAO {
	@Autowired
	EmployeeRepository empRepo;

	public Employee getEmployee(String empNo) {
		return empRepo.findById(empNo).get();
	}

	public Employee addEmployee(Employee emp) {
		return empRepo.save(emp);
	}

	public Employee updateEmployee(Employee emp) {
		Employee existingEmp = empRepo.findById(emp.getEmpNo()).get();
		existingEmp.setEmpNo(emp.getEmpNo());
		existingEmp.setEmpName(emp.getEmpName());
		existingEmp.setPosition(emp.getPosition());
		Employee updatedEmp = empRepo.save(existingEmp);
		return updatedEmp;
	}

	public void deleteEmployee(String empNo) {
		empRepo.deleteById(empNo);
	}

	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}
}
