package estorage.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/packages")
public class PackagesController {

	@RequestMapping("/main")
	public String showPage() {
		return "packages-main";
	}
}
