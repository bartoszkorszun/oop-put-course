package estorage.main.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import estorage.main.entity.Package;

@Controller
@RequestMapping("/packages")
public class PackagesController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@RequestMapping("/main")
	public String showPage() {
		return "packages-main";
	}
	
	@RequestMapping("/entryPackage")
	public String entryPackage() {
		return "entry-package";
	}
	
	Package newPackage;
	
	@RequestMapping("/summary")
	private String sumary(Model model,
			HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException,
					IOException {
		
		doPost(request, response);
		
		model.addAttribute("trackingNumber", newPackage.trackingNumber);
		model.addAttribute("status", newPackage.status);
		model.addAttribute("height", newPackage.height);
		model.addAttribute("width", newPackage.width);
		model.addAttribute("depth", newPackage.depth);
		model.addAttribute("weight", newPackage.weight);
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		model.addAttribute("entryDate", formatter.format(newPackage.dateOfEntry));
		model.addAttribute("deliveryDate", formatter.format(newPackage.dateOfDelivery));
		
		//TODO view
		return null;
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, 
			IOException{
		
		int trackingNumber = Integer.parseInt(request.getParameter("trackingNumber"));
		String status = request.getParameter("status");
		int height = Integer.parseInt(request.getParameter("height"));
		int width = Integer.parseInt(request.getParameter("width"));
		int depth = Integer.parseInt(request.getParameter("depth"));
		int weight = Integer.parseInt(request.getParameter("weight"));
		String dateOfEntry = request.getParameter("entryDate");
		String dateOfDelivery = request.getParameter("deliveryDate");
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date entryDate = new Date();
		Date deliveryDate = new Date();
		
		try {
			entryDate = formatter.parse(dateOfEntry);
			deliveryDate = formatter.parse(dateOfDelivery);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		newPackage = new Package(trackingNumber, status, height, width, depth, weight, entryDate, deliveryDate);
		
		createPackage();
	}
	
	private void createPackage() {
		
		SessionFactory sFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Package.class)
				.buildSessionFactory();
		
		Session session = sFactory.getCurrentSession();
		
		try {
		
			session.beginTransaction();
			session.save(newPackage);
			session.getTransaction().commit();
		
		} finally {
			sFactory.close();
		}
	}
	
	public List<String> trackingNumbers;
	public List<String> statuses;
	public List<String> heights;
	public List<String> widths;
	public List<String> depths;
	public List<String> weights;
	public List<String> datesOfEntry;
	public List<String> datesOfDelivery;
	public List<Integer> ids;
	
	public void viewList() throws SQLException {
		
		trackingNumbers = new ArrayList<>();
		statuses = new ArrayList<>();
		heights = new ArrayList<>();
		widths = new ArrayList<>();
		depths = new ArrayList<>();
		weights = new ArrayList<>();
		datesOfEntry = new ArrayList<>();
		datesOfDelivery = new ArrayList<>();
		ids = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop-put-courier-warehouse?useSSL=false",
					"warehousedb",
					"warehousedb");
			
			statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("select * from package");
			
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			
			while(rs.next()) {
				String trackingNumber = rs.getString("tracking_number");
				String status = rs.getString("status");
				String height = rs.getString("height");
				String width = rs.getString("width");
				String depth = rs.getString("depth");
				String weight = rs.getString("weight");
				String dateOfEntry = formatter.format(rs.getDate("date_of_entry"));
				String dateOfDelivery = formatter.format(rs.getDate("date_of_delivery"));
				int id = rs.getInt("id");
			
				trackingNumbers.add(trackingNumber);
				statuses.add(status);
				heights.add(height);
				widths.add(width);
				depths.add(depth);
				weights.add(weight);
				datesOfEntry.add(dateOfEntry);
				datesOfDelivery.add(dateOfDelivery);
				ids.add(id);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/deletePackage/confirm/{pid}")
	public String confirmDeletePackage(@PathVariable int pid, Model model) {
		model.addAttribute("pid", pid);
		return "confirm-delete-package";
	}
	
	@RequestMapping("/deletePackage/{pid}")
	public String deletePackage(@PathVariable int pid) {
		
		SessionFactory sFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Package.class)
				.buildSessionFactory();
		
		Session session = sFactory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Package myPackage = session.get(Package.class, pid);
			
			if(myPackage != null)
				session.delete(myPackage);
			
			session.getTransaction().commit();
		
		} finally {
			sFactory.close();
		}
		
		return "packages-main";
	}
	
	public PackagesController() {}
}
