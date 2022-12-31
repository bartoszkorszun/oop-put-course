package estorage.main.entity;

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
	
	@Column(name = "tracking_nmumber")
	private int tracking_number;
	
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
	
	// CREATEE FIELD FOR ENTRY DATE
	// CREATEE FIELD FOR DELIVERY DATE
}
