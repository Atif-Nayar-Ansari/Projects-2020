package com.hrms.admin.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hrms.admin.entity.ProjectEntity;
import com.hrms.admin.model.ProjectResponseModel;
import com.hrms.admin.repository.ProjectRepository;
import com.hrms.admin.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	private static Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);

	@Autowired
	private ProjectRepository repo;

	@Override
	public boolean saveProject(ProjectResponseModel project) {
		logger.info("savedProject() called from ProjectServiceImpl class");
		ProjectEntity entity = new ProjectEntity();
		BeanUtils.copyProperties(project, entity);
		repo.save(entity);
		logger.info("one Project is saved from savedProjetc()");
		return true;
		

	}

	@Override
	public List<ProjectResponseModel> getAllProject() {

		logger.info("getAllProject() is called from ProjectServiceImpl class");
		List<ProjectEntity> allProject = repo.findAll();
		List<ProjectResponseModel> projectList = new ArrayList<>();
		for (ProjectEntity pe : allProject) {
			ProjectResponseModel project = new ProjectResponseModel();
			BeanUtils.copyProperties(pe, project);
			projectList.add(project);
		}
		return projectList;
	}

	@Override
	public ProjectResponseModel getOneProject(Integer id) {
		logger.info("getOneProject() is called from ProjectServiceImpl class");
		
		Optional<ProjectEntity> findById = repo.findById(id);
		ProjectResponseModel project = new ProjectResponseModel();

		if (findById.isPresent()) {
			ProjectEntity entity = findById.get();
			BeanUtils.copyProperties(entity, project);
			logger.info("getOneProject() method is returning one Project");
			return project;
		}
		
		logger.error("getOneProject() returning null value");
		return null;
	}

	@Override
	public boolean deleteProject(Integer id) {
		logger.info("deleteProject() is called from ProjectServiceImpl class");
		repo.deleteById(id);
		logger.info("deleteProject() is deleted one Project");
		return true;

	}
	
	@Override
	public boolean updateProjectById(ProjectResponseModel projectModel, int id) {
		logger.info("insert into updateDesignationById method in ProjectServiceImpl class ");
		Optional<ProjectEntity> findById = repo.findById(id);
		if (findById.isPresent()) {
			ProjectEntity oldProjectEntity = findById.get();
			oldProjectEntity.setName(projectModel.getName());
			oldProjectEntity.setDescription(projectModel.getDescription());
			repo.save(oldProjectEntity);
			logger.info(" Project updated successfully in database in ProjectServiceImpl class ");
			return true;
		}
		return false;
	}

	@Override
	public List<ProjectEntity> getAllProjectAccToPaging(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<ProjectEntity> pagedResult = repo.findAll(paging);

			return pagedResult.getContent();
	}
	@Override
	public List<ProjectEntity> getPagination(Pageable p) {
		Page<ProjectEntity> page = repo.findAll(p);
		List<ProjectEntity> content = page.getContent();
		return content;
	}
	
	
}
