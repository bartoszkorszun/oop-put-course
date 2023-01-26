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
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import estorage.main.entity.Employee;
import estorage.main.entity.WorkingHours;
import estorage.main.files.FileManager;

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
		String position = request.getParameter("position");
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		try {
			date = formatter.parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		employee = new Employee(firstName, lastName, date, position);
		 
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
	public List<String> employeesIds;

	public void viewList() throws SQLException {
		
		employeesNames = new ArrayList<>();
		employeesDates = new ArrayList<>();
		employeesPositions = new ArrayList<>();
		employeesIds = new ArrayList<>();
		
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
				String workinghours = rs.getString("id");
				
				employeesNames.add(names);
				employeesDates.add(dates);
				employeesPositions.add(positions);
				employeesIds.add(workinghours);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int eid;
	
	@RequestMapping("/workingHours/{eid}")
	public String workingHours(@PathVariable int eid) {
		this.eid = eid;
		FileManager fm = new FileManager();
		fm.writeToFile(eid);
		return "working-hours";
	}
	
	private WorkingHours workingHours;
	private Long tSum;
	
	@RequestMapping("/submitHours")
	public void submitHours(Model model,
			HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, 
					IOException{
		
		String sDate = request.getParameter("date");
		String startingHour = request.getParameter("startingHour");
		String finishingHour = request.getParameter("finishingHour");
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat timeFormatter = new SimpleDateFormat("h:mm");
		
		Date date = new Date();
		Date dateStartingHour = new Date();
		Date dateFinishingHour = new Date();
		
		try {
			
			date = formatter.parse(sDate);
			dateStartingHour = timeFormatter.parse(startingHour);
			dateFinishingHour = timeFormatter.parse(finishingHour);
			
			tSum = TimeUnit.MILLISECONDS.toHours(dateFinishingHour.getTime() - dateStartingHour.getTime());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int sum = tSum.intValue();
		
		workingHours = new WorkingHours(eid, date, dateStartingHour, dateFinishingHour, sum);
		
		newWorkingHours(model);
		
		String redirect = "http://localhost:8080/eStorage-Management-System/workers/submitHours/" + eid;
		System.out.println(redirect);
		response.sendRedirect(redirect);
	}
	
	public Employee theEmployee;
	
	public void newWorkingHours(Model model) {
		
		SessionFactory sFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(WorkingHours.class)
				.buildSessionFactory();
		
		Session session = sFactory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Query<Employee> query = session.createQuery("select e from Employee e where e.id=" + eid, Employee.class);
			
			theEmployee = query.getSingleResult();
			
			model.addAttribute("nFirstName", theEmployee.firstName);
			
			theEmployee.addWorkingHours(workingHours);
			
			session.save(theEmployee);
			session.getTransaction().commit();
		
		} finally {
			sFactory.close();
		}
	}

	public List<String> whDates;
	public List<String> whSHours;
	public List<String> whFHours;
	public List<Integer> sumH;
	
	@RequestMapping("/submitHours/{eid}")
	public String viewWorkingHours(@PathVariable int eid) {
		return "employee-summary";
	}
	
	public void viewHours() {
		
		FileManager fm = new FileManager();
		int eid = fm.readFromFile();
		
		whDates = new ArrayList<>();
		whSHours = new ArrayList<>();
		whFHours = new ArrayList<>();
		sumH = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop-put-courier-warehouse?useSSL=false",
					"warehousedb",
					"warehousedb");
			
			statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("select * from working_hours where employee_id=" + eid);
			
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat timeFormatter = new SimpleDateFormat("h:mm");
			
			while(rs.next()) {
				
				String sDate = formatter.format(rs.getDate("date"));
				String sHours = timeFormatter.format(rs.getTime("starting_hour"));
				String fHours = timeFormatter.format(rs.getTime("finishing_hour"));
				int iSum = rs.getInt("sum");
				
				whDates.add(sDate);
				whSHours.add(sHours);
				whFHours.add(fHours);
				sumH.add(iSum);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public WorkersController() {}
}