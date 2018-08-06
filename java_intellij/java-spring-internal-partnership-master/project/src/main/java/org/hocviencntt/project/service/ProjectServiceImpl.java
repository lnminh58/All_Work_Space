package org.hocviencntt.project.service;

import org.hocviencntt.project.model.Project;
import org.hocviencntt.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProjectServiceImpl implements ProjectService{
	@Autowired
	ProjectRepository repository;

	public boolean deleteProject(int id) {
		Project project=repository.findOne(id);
		if (project == null) {
			return false;
		}
		repository.delete(id);;
		return true;
	}
	//find a project by Id
	public Project findProject(int id){
		return repository.findOne(id);
	}
	/*update project*/
	public boolean updateProject(int id) {
		Project project=repository.findOne(id);
		if (project != null) {
			project.setName("project PHP");
			repository.save(project);
			return true;
		}else{
			return false;
		}	
	}
}
