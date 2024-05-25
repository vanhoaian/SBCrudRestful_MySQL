package vnua.fita.springboot.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import vnua.fita.springboot.bookstore.dao.EmployeeDAO;
import vnua.fita.springboot.bookstore.model.Employee;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class MainRESTController {

	@Autowired
	private EmployeeDAO employeeDAO;

	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		return "Welcome to RestTemplate Example.";
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<Employee> getEmployees() {
		List<Employee> list = employeeDAO.getAllEmployees();
		return list;
	}

	@RequestMapping(value = "/employee/{empNo}", 
			method = RequestMethod.GET, 
			produces = { MediaType.APPLICATION_JSON_VALUE, 
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Employee getEmployee(@PathVariable("empNo") String empNo) {
		return employeeDAO.getEmployee(empNo);
	}

	@RequestMapping(value = "/employee", 
			method = RequestMethod.POST, 
			produces = { MediaType.APPLICATION_JSON_VALUE, 
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ResponseEntity<?> addEmployee(@RequestBody Employee emp) {
		System.out.println("(Service Side) Creating employee: " + emp.getEmpNo());
		return ResponseEntity.ok(employeeDAO.addEmployee(emp));
	}

	@RequestMapping(value = "/employee", //
			method = RequestMethod.PUT, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ResponseEntity<?> updateEmployee(@RequestBody Employee emp) {
		System.out.println("(Service Side) Editing employee: " + emp.getEmpNo());
		return ResponseEntity.ok(employeeDAO.updateEmployee(emp));
	}

	@RequestMapping(value = "/employee/{empNo}", 
			method = RequestMethod.DELETE, 
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public void deleteEmployee(@PathVariable("empNo") String empNo) {
		System.out.println("(Service Side) Deleting employee: " + empNo);
		employeeDAO.deleteEmployee(empNo);
	}
}
