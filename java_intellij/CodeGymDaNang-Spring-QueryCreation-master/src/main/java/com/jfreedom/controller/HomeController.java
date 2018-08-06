package com.jfreedom.controller;

import java.util.Date;
import java.util.List;
import java.util.Set;


import com.jfreedom.model.Address;
import com.jfreedom.model.Custommer;
import com.jfreedom.model.Product;
import com.jfreedom.service.CustomerService;
import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jfreedom.model.Shop;
import com.jfreedom.service.ShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class HomeController {
	
	@Autowired
	ShopService shopService;
	@Autowired
	CustomerService customerService;

	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String homeHello(@RequestParam("shopname") String name, ModelMap model){
		Shop shop = new Shop();
		shop.setName(name);
		//System.out.println("Name : "+shop.getName());
		model.addAttribute("shop",shop);
		
		return "hello";
	}
	
	@RequestMapping(value="/form", method =RequestMethod.GET)
	public String setupForm( Model model){
		List<Shop> listShops =  shopService.getAllShops();
		for (Shop shop : listShops) {
			System.out.println("shop id" + shop.getId() + "Shop name :"+shop.getName()+" Local: "+shop.getLocal()+" Email : "+shop.getEmail());
		}
		model.addAttribute("allOfShop",listShops);
		return "listShopView";
	}
	@RequestMapping(value = "/findID",method = RequestMethod.GET)
	public String findOne(Model model){
		Shop shop = new Shop();



		 shop = shopService.findOneId();

		List<Custommer> custommerList = shop.getCustommers();
		for (Custommer custommer : custommerList) {
			System.out.println("cus id" + custommer.getId() + "cus name :"+custommer.getCusName()+" addd: "+custommer.getAddress());
		}



		model.addAttribute("shop", shop);
		model.addAttribute("custommerList", custommerList);
		return "findOne";
	}
	@RequestMapping(value = "/searchByName")
	public String searchByName(@RequestParam(value="name", required=false, defaultValue="World")String name,HttpSession session){



		if(name == null){
			session.setAttribute("Lỗi Tìm Kiếm", "Vui Lòng Nhập Lại");
		}else {


			List<Shop> shopListsearch = shopService.findByName(name);
			session.setAttribute("searchName",shopListsearch);




		}
		return "seachView";
	}@RequestMapping(value = "/findByNameLike")
	 public String searchNameLike(@RequestParam(value="name", required=false, defaultValue="World")String name,HttpSession session){



		if(name == null){
			session.setAttribute("Lỗi Tìm Kiếm", "Vui Lòng Nhập Lại");
		}else {


			List<Shop> shopListsearch = shopService.findByNameLike(name);
			session.setAttribute("searchName",shopListsearch);




		}
		return "seachView";
	}

	@RequestMapping(value = "/findByNameContaining")
	public String searchNameContaining(@RequestParam(value="name", required=false, defaultValue="World")String name,HttpSession session){



		if(name == null){
			session.setAttribute("Lỗi Tìm Kiếm", "Vui Lòng Nhập Lại");
		}else {


			List<Shop> shopListsearch = shopService.findByNameContaining(name);
			session.setAttribute("searchName",shopListsearch);




		}
		return "seachView";
	}
	@RequestMapping(value = "/findByNameStartWith")
	public String searchNameStartWith(@RequestParam(value="name", required=false, defaultValue="World")String name,HttpSession session){



		if(name == null){
			session.setAttribute("Lỗi Tìm Kiếm", "Vui Lòng Nhập Lại");
		}else {


			List<Shop> shopListsearch = shopService.findByNameStartingWith(name);
			session.setAttribute("searchName",shopListsearch);




		}
		return "seachView";
	}
	@RequestMapping(value = "/findByNameEndWith")
	public String searchNameEndwith(@RequestParam(value="name", required=false, defaultValue="World")String name,HttpSession session){



		if(name == null){
			session.setAttribute("Lỗi Tìm Kiếm", "Vui Lòng Nhập Lại");
		}else {


			List<Shop> shopListsearch = shopService.findByNameEndingWith(name);
			session.setAttribute("searchName",shopListsearch);




		}
		return "seachView";
	}
	@RequestMapping(value = "/findByNameEngroCase")
	public String searchNameEgnoreCase(@RequestParam(value="name", required=false, defaultValue="World")String name,HttpSession session){



		if(name == null){
			session.setAttribute("l?i t�m ki?m", "?i?n t�n mu?n t�m");
		}else {


			List<Shop> shopListsearch = shopService.findByNameEgnoreCase(name);
			session.setAttribute("searchName",shopListsearch);




		}
		return "seachView";
	}
	@RequestMapping(value = "/searchEmail")
	public String searchEmail(@RequestParam(value="email",required=false, defaultValue="World")String email,HttpSession session){



		if(email == null){
			session.setAttribute("l?i t�m ki?m", "?i?n t�n mu?n t�m");
		}else {


			List<Shop> shopListsearch = shopService.findByEmail(email);
			session.setAttribute("searchName",shopListsearch);




		}
		return "seachView";
	}
	@RequestMapping(value = "/nameandlocal")
	public String searchNameAndlocal(@RequestParam(value="name", defaultValue="World")String name,@RequestParam(value="local",defaultValue="World")String local,HttpSession session){

		List<Shop> shopListsearch = shopService.findByNameAndLocal(name,local);
			session.setAttribute("searchName", shopListsearch);
		return "seachView";
	}

	@RequestMapping(value = "/findBydateafter")
	public String searchDateAfter (@RequestParam(value="date") @DateTimeFormat(pattern = "dd/MM/yyyy") Date date,HttpSession session){

		List<Shop> shopListsearch = shopService.findByDateAfter(date);
		session.setAttribute("searchName", shopListsearch);
		return "seachView";
	}
	@RequestMapping(value = "/findBydateBefore")
	public String searchDateBefore  (@RequestParam(value="date") @DateTimeFormat(pattern = "dd/MM/yyyy") Date date,HttpSession session){

		List<Shop> shopListsearch = shopService.findByDateBefore(date);
		session.setAttribute("searchName", shopListsearch);
		return "seachView";
	}
	@RequestMapping(value = "/findByDateBetween")
	public String searchDateBefore  (@RequestParam(value="date") @DateTimeFormat(pattern = "dd/MM/yyyy") Date from,@RequestParam(value="date") @DateTimeFormat(pattern = "dd/MM/yyyy") Date to,HttpSession session){

		List<Shop> shopListsearch = shopService.findByDateBetween(from,to);
		session.setAttribute("searchName", shopListsearch);
		return "seachView";
	}
	@RequestMapping(value = "/ListAllShop")
	public String searchAllAnotation (Model model){

		List<Shop> shopListsearch = shopService.listAllShop();
		model.addAttribute("ListAllShop", shopListsearch);
		return "listAllShop";
	}
	@RequestMapping(value = "/findAllShop")
	//search by name query
	public String searchFindNameQuery  (Model model){

		List<Shop> shopListsearch = shopService.findAllShop();
		model.addAttribute("ListAllShop", shopListsearch);
		return "listAllShop";
	}
	/*@RequestMapping(value = "/searchByName")
	public String searchName(@RequestParam(value="name", required=false, defaultValue="World")String name,HttpSession session){

//search by name query voi parametter name

		if(name == null){
			session.setAttribute("l?i t�m ki?m", "?i?n t�n mu?n t�m");
		}else {


			List<Shop> shopListsearch = shopService.listAllShopByName(name);
			session.setAttribute("searchName",shopListsearch);




		}
		return "seachView";
	}*/
	@RequestMapping(value = "/findCus",method = RequestMethod.GET)
	public String findOnecus(Model model){
		Custommer custommer = new Custommer();
		custommer = customerService.findOneid();
		Address address = custommer.getAdd();

			System.out.println("add id" + address.getId() + "street name :" + address.getStreetName() + " streetnumber: " + address.getStreetNumber() + "city:" + address.getCity());
		model.addAttribute("address", address);

		return "findOne";
	}
	@RequestMapping(value = "/findCusManytomany",method = RequestMethod.GET)
	public String searchCusName(@RequestParam(value="name", required=false, defaultValue="World")String cusName,HttpSession session){
		List<Custommer> custommerList = customerService.findBycusName(cusName);

		for (Custommer c : custommerList) {

			Set<Product> productList = c.getProductSet();
			for (Product p : productList) {
				System.out.println("product id:" + p.getId() + "product name :" + p.getName() + " product price: " + p.getPrice());

			}
		}
			session.setAttribute("custommerList",custommerList);

		return "customer";
	}


}
