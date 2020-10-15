
package com.hrms.admin.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.hrms.admin.entity.ProjectEntity;
import com.hrms.admin.model.ProjectResponseModel;
import com.hrms.admin.repository.ProjectRepository;
import com.hrms.admin.service.impl.ProjectServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProjectServiceTest {

	@Mock
	private ProjectRepository repository;

	@InjectMocks
	private ProjectServiceImpl service;
	 
	@Mock
	Page<ProjectEntity> entity;
	
	

	@Test
	public void testSaveProject() {
		
		ProjectResponseModel model = new ProjectResponseModel();
		model.setId(1);
		model.setName("Na");
		model.setDescription("Hi");
		boolean result = service.saveProject(model);
		assertEquals(true,result);
	}
	
	@Test
	public void testGetAllProject() {
		
		ProjectEntity entity1 = new ProjectEntity();
		entity1.setId(1);;
		entity1.setDescription("cool");
		entity1.setName("Name");
		
		ProjectEntity entity2 = new ProjectEntity();
		entity2.setId(1);;
		entity2.setDescription("cool");
		entity2.setName("Name");
		
		List<ProjectEntity> listEntity = new ArrayList<>();
		listEntity.add(entity1);
		listEntity.add(entity2);
		when(repository.findAll()).thenReturn(listEntity);
		List<ProjectResponseModel> allProject = service.getAllProject();
		assertEquals(2, allProject.size());
		
	}
	
	@Test
	public void testGetOneProjectPositive() {
		
		Optional<ProjectEntity> projectEntity = Optional.of(new ProjectEntity());
		
		ProjectResponseModel models = new ProjectResponseModel();
		
		models.setDescription("developer");
		models.setId(1);
		models.setName("Jonathan");

		when(repository.findById(1)).thenReturn(projectEntity);
		
		ProjectResponseModel oneProject = service.getOneProject(1);
	
		assertNotNull(oneProject);
	}
	
	@Test
	public void testGetOneProjectNegative() {
		
	//	Optional<ProjectEntity> desigantionEntity = Optional.of(new ProjectEntity());
		when(repository.findById(1)).thenReturn(Optional.empty());
		ProjectResponseModel model = service.getOneProject(1);
		assertEquals(null,model);
	}
	
	@Test
	public void testDeleteProject() {
		
		Optional<ProjectEntity> projectEntity = Optional.of(new ProjectEntity());
		when(repository.findById(1)).thenReturn(projectEntity);
		boolean delete = service.deleteProject(1);
		assertEquals(true,delete);
	}
/*	
	@Test 
	public void deleteDesignationByidNotfound(){ 
		// DesignationEntity
		designationEntity=new DesignationEntity();
		when(designationrepository.findById(2l)).thenReturn(Optional.empty());
		boolean designationById=designationServiceimp.deleteDesignationById(2l);
		assertEquals(true,designationById);
		}
	
*/	
	@Test
	public void testUpdateProjectByIdPositive() {
		
		Optional<ProjectEntity> projectEntity = Optional.of(new ProjectEntity());
		when(repository.findById(1)).thenReturn(projectEntity);
		ProjectResponseModel model = new ProjectResponseModel();
		model.setId(1);
		model.setName("same");
		model.setDescription("developer");
		boolean update = service.updateProjectById(model, 1);
		assertEquals(true, update);
	}
	@Test
	public void testUpdateProjectByIdNegative() {

		when(repository.findById(1)).thenReturn(Optional.empty());
		ProjectResponseModel model = new ProjectResponseModel();
		model.setId(1);
		model.setName("same");
		model.setDescription("developer");
		boolean update = service.updateProjectById(model, 1);
		assertEquals(false, update);
	}
	@Test
	public void testGetAllProjectAccToPaging() {
		
		Pageable paging = PageRequest.of(0, 1, Sort.by("id"));

		 
		when(repository.findAll(paging)).thenReturn(entity);
		
		List<ProjectEntity> list = service.getAllProjectAccToPaging(0, 1, "id");
		assertNotNull(list);
			
	}
	
	
}
