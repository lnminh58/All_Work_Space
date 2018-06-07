package org.hocviencntt.web.controller;

import org.hocviencntt.user.model.Profile;
import org.hocviencntt.user.model.User;
import org.hocviencntt.user.service.ProfileService;
import org.hocviencntt.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {
//	@Autowired
//	private ProfileService profileService;
//	
//	@RequestMapping(value="/profile" , method=RequestMethod.GET)
//	public String showProfile(Model model,@RequestParam(value="username") String username){
//		Profile profile = profileService.loadProfile(username);
//		System.out.println("user:"+profile.getUserName());
//		System.out.println("firstname:"+profile.getFirstName());
//		System.out.println("lastname:" + profile.getLastName());
//		System.out.println("email:"+profile.getEmail());
//		System.out.println("phone:"+profile.getPhone());
//		model.addAttribute("profile", profile);
//		return "profile";
//	}
	@Autowired
	private UserService userService;
	@RequestMapping(value="/profile" , method=RequestMethod.GET)
	public String showProfile(Model model,@RequestParam(value="username") String username){
		User user = userService.findUser(username);
		
		model.addAttribute("user", user);
		return "profile";
	}
	
}
