package estorage.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/workers")
public class WorkersController {

	@RequestMapping("/main")
	public String showPage() {
		return "workers-main";
	}
}
