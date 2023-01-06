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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
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
}
