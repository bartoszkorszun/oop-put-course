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
	private int trackingNumber;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "height")
	private int height;
	
	@Column(name = "width")
	private int width;
	
	@Column(name = "depth")
	private int depth;
	
	@Column(name = "weight")
	private int weight;
	
	@Column(name = "date_of_entry")
	private Date dateOfEntry;
	
	@Column(name = "date_of_delivery")
	private Date dateOfDelivery;

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

	@Override
	public String toString() {
		return "Package [trackingNumber=" + trackingNumber + ", status=" + status + ", height=" + height + ", width="
				+ width + ", depth=" + depth + ", weight=" + weight + ", dateOfEntry=" + dateOfEntry
				+ ", dateOfDelivery=" + dateOfDelivery + "]";
	}
}
