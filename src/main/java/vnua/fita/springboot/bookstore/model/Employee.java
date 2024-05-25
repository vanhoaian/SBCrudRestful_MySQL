package vnua.fita.springboot.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Employee {
	@Id
	@NotBlank(message = "empNo is not empty")
	private String empNo;
	@NotBlank(message = "empName is not empty")
	private String empName;
	@NotBlank(message = "position is not empty")
	private String position;

	public Employee() {
	}

	public Employee(String empNo, String empName, String position) {
		this.empNo = empNo;
		this.empName = empName;
		this.position = position;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
}
