package estorage.main.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String position = request.getParameter("position");
		String isAdmin = request.getParameter("admin"); // Zwraca on albo null, najlepiej jakby udało się przekonwertować na boolean
	}
}