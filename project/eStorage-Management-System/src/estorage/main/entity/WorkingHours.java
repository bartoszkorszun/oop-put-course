package estorage.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "working_hours")
public class WorkingHours {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	// CREATE DATE FIELD
	// CREATE STARTING HOUR FIELD
	// CREATE FINNISHING HOUR FIELD
	
	@Column(name = "sum")
	private int sum;
}
