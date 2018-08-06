package org.hocviencntt.web.controller;

import java.util.List;

import org.hocviencntt.user.model.User;
import org.hocviencntt.user.service.SecurityService;
import org.hocviencntt.user.service.UserService;
import org.hocviencntt.user.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePage {
	
	@Autowired
	UserService userService;
    @Autowired
    private SecurityService securityService;



   @RequestMapping(value ="/", method = RequestMethod.GET)
   public String homePage(Model model) {
	   List<User> users = userService.findPartnerSuggest();
	   model.addAttribute("usersSuggest" , users);
       return "home";
   }
   @Autowired
   private UserValidator userValidator;

   @RequestMapping(value = "/registration", method = RequestMethod.GET)
   public String registration(Model model) {
       model.addAttribute("userForm", new User());

       return "registration";
   }

   @RequestMapping(value = "/registration", method = RequestMethod.POST)
   public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
       userValidator.validate(userForm, bindingResult);

       if (bindingResult.hasErrors()) {
           return "registration";
       }

       userService.save(userForm);

       securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
       model.addAttribute("username", userForm.getUsername());

       return "redirect:/profile/?username=${username}";
   }
   
   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public String login(Model model, String error, String logout) {
       if (error != null)
           model.addAttribute("error", "Your username and password is invalid.");

       if (logout != null)
           model.addAttribute("message", "You have been logged out successfully.");

       return "login";
   } 
}
