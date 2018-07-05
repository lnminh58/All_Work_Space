package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/basic")
public class BasicController {
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index() {
		
	   return "basic.index";//ten giong o template.xml
	} 
	@RequestMapping(value="/cat", method=RequestMethod.GET)
	public String cat() {
		
	   return "basic.cat";
	} 
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public String user() {
		
	   return "basic.user";
	} 

}
