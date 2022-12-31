package estorage.main.entity;

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
	// CREATE DATE FIELD
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "is_admin")
	private int isAdmin = 0;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "working_hours_id")
	private WorkingHours workingHours;
	
	public Employee(String firstName, 
					String lastName, 
					String login, 
					String password, 
					int isAdmin) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	@Override
	public void fillWorkingHours() {
		
		
	}
}
