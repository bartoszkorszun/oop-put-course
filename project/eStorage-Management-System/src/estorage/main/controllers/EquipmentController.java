package estorage.main.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;

import estorage.main.entity.Equipment;

@Controller
@RequestMapping("/equipment")
public class EquipmentController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@RequestMapping("/main")
	public String showPage() {
		return "equipment-main";
	}
	
	@RequestMapping("newEquipment")
	public String newEquipment() {
		return "new-equipment";
	}
	
	Equipment equipment;
	
	@RequestMapping("/summary")
	private String summary(Model model,
			HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException,
					IOException {
		
		doPost(request, response);
		
		model.addAttribute("type", equipment.type);
		model.addAttribute("amount", equipment.amount);
		
		// TODO view
		return null;
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException, 
					IOException {
		
		String type = request.getParameter("type");
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		equipment = new Equipment(type, amount);
		 
		createEquipment();
	}
		
	private void createEquipment() {
		
		SessionFactory sFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Equipment.class)
				.buildSessionFactory();
		
		Session session = sFactory.getCurrentSession();
		
		try {
		
			session.beginTransaction();
			session.save(equipment);
			session.getTransaction().commit();
		
		} finally {
			sFactory.close();
		}
	}
	
	public List<String> types;
	public List<String> amount;
	
	public void viewList() throws SQLException {
		
		types = new ArrayList<>();
		amount = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop-put-courier-warehouse?useSSL=false",
					"warehousedb",
					"warehousedb");
			
			statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("select * from equipment");
			
			while(rs.next()) {
				String sTypes = rs.getString("type");
				String sAmount = rs.getString("amount");
				
				types.add(sTypes);
				amount.add(sAmount);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public EquipmentController() {}
}
