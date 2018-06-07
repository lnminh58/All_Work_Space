package org.hocviencntt.web.controller;

import java.util.List; 

import org.hocviencntt.project.model.Project;
import org.hocviencntt.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	@RequestMapping(value="/updateproject",method =RequestMethod.GET)
	public String updateProject(@RequestParam(value="id") int id, Model model ){
		boolean isSuccessUpdate = projectService.updateProject(id);
		if (isSuccessUpdate) {
			Project project = projectService.findProject(id);
			model.addAttribute("updateProject", project);
			return "listResult";
		}else{
		return "HomeError";
		}
	}
	
	@RequestMapping(value="/deleteproject",method=RequestMethod.GET)
	public String deleteProject(@RequestParam(value="id") int id){
		if (projectService.deleteProject(id)) {
			return "listResult";
		}
		return "HomeError";
	}
	@RequestMapping(value="/project",method=RequestMethod.GET)
	public String project(){
		return "listResult";
	}
	
}
