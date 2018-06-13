package codegymdanang.spring.tiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping(value="/hello")
	public String showViewHello(Model model) {
		model.addAttribute("mgs", "Hello. Spring Framework.");
		return "hello";
	}
	
	@RequestMapping(value="/home")
	public ModelAndView showViewHome() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("mgs", "Tiles Topic.");
		return modelAndView;
	}
	
	
}
