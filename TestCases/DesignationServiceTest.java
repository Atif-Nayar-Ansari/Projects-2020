package com.atif.ansari.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.atif.ansari.controller.DesignationController;
import com.atif.ansari.entity.DesignationEntity;
import com.atif.ansari.model.DesignationModel;
import com.atif.ansari.repository.Designationrepository;
import com.atif.ansari.service.impl.DesignationServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
//@WebMvcTest(value = DesignationService.class)
public class DesignationServiceTest {

	@Mock
	private Designationrepository designationrepository;

	/*
	 * @Mock private DesignationController designationEntity;
	 */

	@InjectMocks
	private DesignationServiceImpl designationServiceimp;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllDesignations() {

		List<DesignationEntity> designationModels = new ArrayList<DesignationEntity>();
		
		DesignationEntity designationOne = new DesignationEntity();
		designationOne.setDesignationName("manager");
		designationOne.setSkills("java & angular");
		designationOne.setExperiance(12);
		DesignationEntity designaionTwo = new DesignationEntity();
		designaionTwo.setDesignationName("Developer");
		designaionTwo.setSkills("java");
		designaionTwo.setExperiance(3);

		designationModels.add(designationOne);
		designationModels.add(designaionTwo);

		when(designationrepository.findAll()).thenReturn(designationModels);

		List<DesignationModel> designationEntity = designationServiceimp.getAllDesignatioins();

		assertEquals(2, designationEntity.size());

	}


	@Test
	public void getDesignationById() {
		Optional<DesignationEntity> desigantionEntity=Optional.of(new  DesignationEntity());
		DesignationModel designationModels = new DesignationModel();
		designationModels.setDesignationName("Developer");
		designationModels.setSkills("java");
		designationModels.setExperiance(3);

		when(designationrepository.findById(1L)).thenReturn(desigantionEntity);
		DesignationModel desigantionById = designationServiceimp.getDesignationById(1L);
		assertEquals(null, desigantionById.getDesignationName());
	}

	@Test
	public void getDesignationByIdNagativeCase() {
		//Optional<DesignationEntity> desigantionEntity=Optional.of(new  DesignationEntity());
		when(designationrepository.findById(1L)).thenReturn(Optional.empty());
		DesignationModel desigantionById = designationServiceimp.getDesignationById(1L);
		assertEquals(null, desigantionById);
	}
	
	@Test
	public void deleteDesignationByid()
	{
		Optional<DesignationEntity> designationEntity=Optional.of(new DesignationEntity());
		when(designationrepository.findById(2l)).thenReturn(designationEntity);
		boolean designationById=designationServiceimp.deleteDesignationById(2l);
		assertEquals(true, designationById);
	}

	@Test
	public void deleteDesignationByidNotfound()
	{
		//DesignationEntity designationEntity=new DesignationEntity();
		when(designationrepository.findById(2l)).thenReturn(Optional.empty());
		boolean designationById=designationServiceimp.deleteDesignationById(2l);
		assertEquals(true, designationById);
	}

}
