package com.hrms.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.admin.entity.ProjectEntity;
import com.hrms.admin.exceptions.Response;
import com.hrms.admin.model.ProjectResponseModel;
import com.hrms.admin.service.ProjectService;
import com.hrms.admin.util.Constants;

@RestController
@CrossOrigin
@RequestMapping("/admin/project")
public class ProjectController {

	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

	@Autowired
	private ProjectService service;

	/**
	 * This operation indicate Read Json data from Http Requset(Body) and convert
	 * into object using @RequestBody Annotation By using serviceLayer save data to
	 * Project table
	 * 
	 * @param Project
	 * @return ResponseEntity<String>
	 */

	@PostMapping
	public ResponseEntity<Response> save(@RequestBody ProjectResponseModel project) {

		try {
			logger.info("Enter into saveProject() method in ProjectRestController Class");
			service.saveProject(project);
			logger.info("In saveProject() One project is saved");
			return new ResponseEntity<Response>(
					new Response("Project " + " " + Constants.INSERT_SUCCESS, Constants.TRUE), HttpStatus.CREATED);

		} catch (Exception e) {
			logger.error("Project not saved exception occured" + e);
			return new ResponseEntity<Response>(new Response("Project " + " " + Constants.INSERT_FAIL, Constants.FALSE),
					HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * This operations takes no Input, if you want you can Accept Header (optional)
	 * Default Gives JSON Output if data exist, else returns empty collection like
	 * [].
	 * 
	 * @return ResponseEntity
	 */

	@GetMapping
	public List<ProjectResponseModel> getAll() {
		logger.info("insert into getAllDesignations method from DesignationController class ");
		return service.getAllProject();
	}
	/**
	 * Client makes Request using PathVariable. If given id exist then service
	 * returns Project
	 * 
	 * @param id
	 * @return ResponseEntity
	 */

	/*
	 * @GetMapping("/{id}") public ResponseEntity<Response>
	 * getOneProject(@PathVariable Integer id) { ResponseEntity<Response> resp; try
	 * {
	 * 
	 * logger.
	 * info("Enter into getOneProject() method in ProjectRestController class");
	 * ProjectResponseModel oneProject = service.getOneProject(id);
	 * logger.info("get one Project from getOneProject()"); resp = new
	 * ResponseEntity<>(project, HttpStatus.OK); return resp; } catch (Exception e)
	 * { logger.error("No Data Found in getOneProject()" + e); throw new
	 * ProjectNotFoundException("Project is not available" + id); }
	 * 
	 * }
	 */

	/***
	 * Client makes Request using PathVariable. If given id exist then service
	 * delete Project
	 * 
	 * @param id
	 * @return ResponseEntity
	 */

	@DeleteMapping("/{id}")
	public ResponseEntity<Response> deleteProject(@PathVariable Integer id) {

		logger.info("Enter into deleteProject() method in ProjectRestController class");
		service.deleteProject(id);
		logger.info("removed one Project from deleteProject()");
		return new ResponseEntity<Response>(new Response("Project " + " " + Constants.DELETE_SUCCESS, Constants.TRUE),
				HttpStatus.OK);

	}

	/***
	 * Client makes a request to Update a particular project
	 * 
	 * @return ResponseEntity
	 */

	// update Designation by id
	@PutMapping("/{id}")
	public ResponseEntity<Response> update(@RequestBody ProjectResponseModel ProjectModel, int id) {
		logger.info("insert into update method from projectController class ");
		try {
			service.updateProjectById(ProjectModel, id);
			return new ResponseEntity<Response>(
					new Response("Project " + " " + Constants.UPDATE_SUCCESS, Constants.TRUE), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Response>(new Response("Project " + " " + Constants.UPDATE_FAIL, Constants.FALSE),
					HttpStatus.CREATED);
		}
	}

	// Pagination
	@GetMapping("/paging")
	public ResponseEntity<List<ProjectEntity>> getAllProjectByPaging(@RequestParam(defaultValue = "2") Integer pageNo,
			@RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy) {
		List<ProjectEntity> list = service.getAllProjectAccToPaging(pageNo, pageSize, sortBy);

		return new ResponseEntity<List<ProjectEntity>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	// --Experiments
	@GetMapping("/p")
	public ResponseEntity<List<ProjectEntity>> getPageData(){
		PageRequest p = PageRequest.of(0, 2);
		List<ProjectEntity> pagination = service.getPagination(p);
		return new ResponseEntity<List<ProjectEntity>>(pagination,HttpStatus.OK);
	
	}

}
