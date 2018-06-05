package codegymdanang.spring.hellospringmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloSpringController {
	
	@RequestMapping(value= {"/","/*","/home"})
	public String showViewHome() {
		return "home";
	}
}
