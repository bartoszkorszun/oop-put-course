package estorage.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {

	@RequestMapping("/main")
	public String showPage() {
		return "equipment-main";
	}
}
