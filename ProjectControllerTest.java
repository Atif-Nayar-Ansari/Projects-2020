package com.hrms.admin.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrms.admin.model.ProjectResponseModel;
import com.hrms.admin.service.ProjectService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProjectController.class)
public class ProjectControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProjectService service;

	@Test
	public void testGetAll() throws Exception {
		ProjectResponseModel model1 = new ProjectResponseModel(1, "smith", "cool");
		ProjectResponseModel model2 = new ProjectResponseModel(1, "smith", "cool");
		ProjectResponseModel model3 = new ProjectResponseModel(1, "smith", "cool");
		List<ProjectResponseModel> list = new ArrayList<>();
		list.add(model1);
		list.add(model2);
		list.add(model3);
		when(service.getAllProject()).thenReturn(list);
		MockHttpServletRequestBuilder reqObj = MockMvcRequestBuilders.get("/admin/project");
		MvcResult result = mockMvc.perform(reqObj).andReturn();
		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
	}

	// save positive
	@Test
	public void testSaveProjectPositive() throws Exception {

		when(service.saveProject(Mockito.any(ProjectResponseModel.class))).thenReturn(true);

		ProjectResponseModel model = new ProjectResponseModel();
		model.setName("A");
		model.setId(1);
		model.setDescription("d");

		ObjectMapper mapper = new ObjectMapper();
		String postReq = mapper.writeValueAsString(model);
		
		MockHttpServletRequestBuilder content = MockMvcRequestBuilders.post("/admin/project")
				.contentType(MediaType.APPLICATION_JSON).content(postReq);
	
		MvcResult andReturn = mockMvc.perform(content).andReturn();
		
		MockHttpServletResponse request = andReturn.getResponse();
		
		int status = request.getStatus();
		assertEquals(201, status);
	}
	//save Negative for exception
	@Test
	public void testSaveProjectNegatice() throws Exception {
	
	}
	
	//to test the delete functionality
	@Test
	public void testDeleteProject() throws Exception {
		when(service.deleteProject(1)).thenReturn(true);
		MockHttpServletRequestBuilder content = MockMvcRequestBuilders.delete("/admin/project/1");
		MvcResult andReturn = mockMvc.perform(content).andReturn();
		MockHttpServletResponse response = andReturn.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
	}
	
	//test the put Positive
/*	@Test
	public void updatePositive() throws Exception {
		when(service.updateProjectById(Mockito.any(ProjectResponseModel.class),Mockito.anyInt())).thenReturn(true);
		
		ProjectResponseModel model = new ProjectResponseModel();
		model.setName("A");
		model.setId(1);
		model.setDescription("d");
		Integer id = 1;
		ObjectMapper mapper = new ObjectMapper();
		String postReq = mapper.writeValueAsString(model);
		
		MockHttpServletRequestBuilder content = MockMvcRequestBuilders.put("/admin/project/"+id)
				.contentType(MediaType.APPLICATION_JSON).content(postReq);
	
		MvcResult andReturn = mockMvc.perform(content).andReturn();
		
		MockHttpServletResponse request = andReturn.getResponse();
		
		int status = request.getStatus();
		assertEquals(200, status);
	} */
	
}
