package estorage.main.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import estorage.main.entity.Employee;

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
	
	@RequestMapping("/employeeProfile")
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
		boolean isAdmin = (request.getParameter("admin") != null); // Zwraca on albo null, najlepiej jakby udało się przekonwertować na boolean
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		try {
			date = formatter.parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Employee employee = new Employee(firstName, lastName, date, login, password, position, isAdmin);
		System.out.println(employee.toString());
	}
}