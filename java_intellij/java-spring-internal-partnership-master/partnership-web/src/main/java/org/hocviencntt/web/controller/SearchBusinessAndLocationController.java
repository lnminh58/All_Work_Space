package org.hocviencntt.web.controller;

import java.util.List;

import org.hocviencntt.business.model.Business;
import org.hocviencntt.business.service.BusinessService;
import org.hocviencntt.location.model.Location;
import org.hocviencntt.location.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchBusinessAndLocationController {

	@Autowired
	private BusinessService businessService;

	@Autowired
	private LocationService locationService;


	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchBusinessAndLocation(@RequestParam("name") String name, @RequestParam("city") String city,
			Model model) {
		List<Business> listBusinesses = businessService.findByBusiness(name);
		List<Location> listLocations = locationService.findByLocation(city);
		for (Business business : listBusinesses) {
			for (Location location : listLocations) {
				if (business.getUser().getUsername().equals(location.getUser().getUsername())) {
					model.addAttribute("listSearch", listLocations);
				}
			}
		}
		return "listView";
	}

}