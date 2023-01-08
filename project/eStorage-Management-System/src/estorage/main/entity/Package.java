package estorage.main.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "package")
public class Package {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "tracking_number")
	public int trackingNumber;
	
	@Column(name = "status")
	public String status;
	
	@Column(name = "height")
	public int height;
	
	@Column(name = "width")
	public int width;
	
	@Column(name = "depth")
	public int depth;
	
	@Column(name = "weight")
	public int weight;
	
	@Column(name = "date_of_entry")
	public Date dateOfEntry;
	
	@Column(name = "date_of_delivery")
	public Date dateOfDelivery;

	public Package(int trackingNumber, 
			String status, 
			int height, 
			int width, 
			int depth, 
			int weight, 
			Date dateOfEntry,
			Date dateOfDelivery) {
		
		this.trackingNumber = trackingNumber;
		this.status = status;
		this.height = height;
		this.width = width;
		this.depth = depth;
		this.weight = weight;
		this.dateOfEntry = dateOfEntry;
		this.dateOfDelivery = dateOfDelivery;
	}
}
