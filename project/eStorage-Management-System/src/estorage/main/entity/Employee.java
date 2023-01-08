package estorage.main.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import estorage.main.interfaces.EmployeeInterface;

@Entity
@Table(name = "employee")
public class Employee implements EmployeeInterface {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	public String firstName;
	
	@Column(name = "last_name")
	public String lastName;
	
	@Column(name = "date_of_birth")
	public Date date;
	
	@Column(name = "position")
	public String position;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "working_hours_id")
	private WorkingHours workingHours;
	
	public Employee() {
		
	}
	
	public Employee(String firstName, 
			String lastName, 
			Date date,
			String position) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
		this.position = position;
	}

	@Override
	public void addWorkingHours(WorkingHours workingHours) {
		this.workingHours = workingHours;
	}
}
