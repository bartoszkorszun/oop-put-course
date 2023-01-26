package estorage.main.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "working_hours")
public class WorkingHours {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "employee_id")
	private int employeeId;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "starting_hour")
	private Date startingHour;
	
	@Column(name = "finishing_hour")
	private Date finishingHour;
	
	@Column(name = "sum")
	private int sum;
	
	@OneToOne(mappedBy = "workingHours", cascade = {CascadeType.ALL})
	private Employee employee;

	public WorkingHours() {
		
	}
	
	public WorkingHours(int empoyeeId,
			Date date, 
			Date startingHour, 
			Date finishingHour, 
			int sum) {
		
		this.employeeId = empoyeeId;
		this.date = date;
		this.startingHour = startingHour;
		this.finishingHour = finishingHour;
		this.sum = sum;
	}
}
