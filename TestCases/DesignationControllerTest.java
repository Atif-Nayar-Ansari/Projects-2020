package com.atif.ansari.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.atif.ansari.model.DesignationModel;
import com.atif.ansari.service.DesignationService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = DesignationController.class)
public class DesignationControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	DesignationService designationService;

	@Test
	public void getAllDesignationsTest() throws Exception {

		MockHttpServletRequestBuilder getReq = MockMvcRequestBuilders.get("/designaions");

		MvcResult result = mockMvc.perform(getReq).andReturn();

		MockHttpServletResponse response = result.getResponse();

		int status = response.getStatus();

		assertEquals(200, status);
	}

	@Test
	public void fetchOneDepartmentByIdTest() throws Exception {

		final DesignationModel designationModel = new DesignationModel("Java Developer", "java", 3);

		when(designationService.getDesignationById(1L)).thenReturn(designationModel);

		MockHttpServletRequestBuilder getReq = MockMvcRequestBuilders.get("/designaions/1");

		MvcResult result = mockMvc.perform(getReq).andReturn();

		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
	}

	@Test
	public void fetchOneDesignationByIdNoFoundTest() throws Exception {

		when(designationService.getDesignationById(5L)).thenReturn(null);

		MockHttpServletRequestBuilder getReq = MockMvcRequestBuilders.get("/id");
		MvcResult andReturn = mockMvc.perform(getReq).andReturn();
		int status1 = andReturn.getResponse().getStatus();
		assertEquals(404, status1);
	}

	@Test
	public void deleteDesignationByIdTest() throws Exception {

		when(designationService.deleteDesignationById(1L)).thenReturn(true);

		MockHttpServletRequestBuilder getReq = MockMvcRequestBuilders.delete("/designaions/1");

		MvcResult result = mockMvc.perform(getReq).andReturn();

		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
	}

	@Test
	public void deleteDesignationByIdNotFoundTest() throws Exception {

		when(designationService.deleteDesignationById(1L)).thenReturn(false);

		MockHttpServletRequestBuilder getReq = MockMvcRequestBuilders.delete("/designaions/1");

		MvcResult result = mockMvc.perform(getReq).andReturn();

		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
	}

}
