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
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "date_of_birth")
	private Date date;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "position")
	private String position;
	
	@Column(name = "is_admin")
	private String isAdmin;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "working_hours_id")
	private WorkingHours workingHours;
	
	public Employee() {
		
	}
	
	public Employee(String firstName, 
			String lastName, 
			Date date,
			String login, 
			String password,
			String position,
			String isAdmin) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
		this.login = login;
		this.password = password;
		this.position = position;
		this.isAdmin = isAdmin;
	}

	@Override
	public void addWorkingHours(WorkingHours workingHours) {
		this.workingHours = workingHours;
	}
}
