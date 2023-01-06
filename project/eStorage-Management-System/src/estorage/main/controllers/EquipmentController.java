package estorage.main.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
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
}
