package com.atif.ansari.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.atif.ansari.entity.DesignationEntity;
import com.atif.ansari.model.DesignationModel;
import com.atif.ansari.repository.Designationrepository;
import com.atif.ansari.service.DesignationService;

@Service
public class DesignationServiceImpl implements DesignationService {

	@Autowired
	Designationrepository designationrepository;

	// get all the designations
	@Override
	public List<DesignationModel> getAllDesignatioins() {
		List<DesignationEntity> findAll = designationrepository.findAll();
		List<DesignationModel> models = new ArrayList<DesignationModel>();
		for (DesignationEntity Entity : findAll) {
			DesignationModel model = new DesignationModel();
			BeanUtils.copyProperties(Entity, model);
			models.add(model);
		}
		return models;
	}

	// get the designation by id
	@Override
	public DesignationModel getDesignationById(Long id) {
		Optional<DesignationEntity> designation = designationrepository.findById(id);
		DesignationEntity designationEntity = designation.get();
		DesignationModel model = new DesignationModel();
		BeanUtils.copyProperties(designationEntity, model);
		return model;
	}

	// to save designation
	@Override
	public boolean createDesignation(@RequestBody DesignationModel designationModel) {
		DesignationEntity entity = new DesignationEntity();
		BeanUtils.copyProperties(designationModel, entity);
		designationrepository.save(entity);
		return true;
	}

	// update the designation
	@Override
	public boolean updateDesignationById(@RequestBody DesignationModel designationModel, @PathVariable long id) {
		Optional<DesignationEntity> findById = designationrepository.findById(id);
		if (findById.isPresent()) {
			DesignationEntity olddesignationEntity = findById.get();
			olddesignationEntity.setDesignationName(designationModel.getDesignationName());
			olddesignationEntity.setSkills(designationModel.getSkills());
			olddesignationEntity.setExperiance(designationModel.getExperiance());
			designationrepository.save(olddesignationEntity);
			return true;
		}
		return false;
	}

	// delete designation by id
	@Override
	public boolean deleteDesignationById(Long id) {

		designationrepository.deleteById(id);
		return true;

	}

}
