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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import estorage.main.entity.Employee;
import estorage.main.entity.WorkingHours;

@Controller
@RequestMapping("/workers")
public class WorkersController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@RequestMapping("/main")
	public String showMainPage() {
		return "workers-main";
	}
	
	@RequestMapping("/addNewWorker")
	public String addNewWorker() {
		return "new-worker";
	}
	
	private Employee employee;
	
	@RequestMapping("/employeeProfile")
	private String employeeProfile(Model model,
			HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException,
					IOException {
		
		doPost(request, response);
		
		model.addAttribute("firstName", employee.firstName);
		model.addAttribute("lastName", employee.lastName);
		model.addAttribute("position", employee.position);
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		model.addAttribute("birthDate", formatter.format(employee.date));
		
		return "employee-profile";
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException, 
					IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String sDate = request.getParameter("birthDate");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String position = request.getParameter("position");
		boolean admin = (request.getParameter("admin") != null); 
		
		String isAdmin;
		
		if(admin)
			isAdmin = "true";
		else
			isAdmin = "false";
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		try {
			date = formatter.parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		employee = new Employee(firstName, lastName, date, login, password, position, isAdmin);
		 
		createEmployee();
	}
		
	private void createEmployee() {
		
		SessionFactory sFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(WorkingHours.class)
				.buildSessionFactory();
		
		Session session = sFactory.getCurrentSession();
		
		try {
		
			employee.addWorkingHours(new WorkingHours());
			
			session.beginTransaction();
			session.save(employee);
			session.getTransaction().commit();
		
		} finally {
			sFactory.close();
		}
	}
	
	public List<String> employeesNames;
	public List<String> employeesDates;
	public List<String> employeesPositions;

	public void viewList() throws SQLException {
		
		employeesNames = new ArrayList<>();
		employeesDates = new ArrayList<>();
		employeesPositions = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop-put-courier-warehouse?useSSL=false",
					"warehousedb",
					"warehousedb");
			
			statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("select * from employee");
			
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			
			while(rs.next()) {
				String names = rs.getString("first_name")
						+ ' ' + rs.getString("last_name");
				String dates = formatter.format(rs.getDate("date_of_birth"));
				String positions = rs.getString("position");
				
				employeesNames.add(names);
				employeesDates.add(dates);
				employeesPositions.add(positions);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public WorkersController() {}
}