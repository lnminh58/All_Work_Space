package org.hocviencntt.project.service;

import org.hocviencntt.project.model.Project;

public interface ProjectService {
	public boolean deleteProject(int id);
	public boolean updateProject(int id);
	public Project findProject(int id);
}
