package com.nt.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entities.CityMasterEntity;
import com.nt.entities.CountryMasterEntity;
import com.nt.entities.StateMasterEntity;
import com.nt.entities.UserAccountsEntity;
import com.nt.repositories.CityMasterRepository;
import com.nt.repositories.CountryMasterRepository;
import com.nt.repositories.StateMasterRepository;
import com.nt.repositories.UserAccountsRepository;
import com.nt.utility.TempPasswordGenarator;

@Service
public class UserManagementServiceImpl implements UserManagementService {

	
	@Autowired
	private UserAccountsRepository uaRepo;
	
	@Autowired
	private CountryMasterRepository cmRepo;
	
	@Autowired
	private StateMasterRepository smRepo;
	
	@Autowired
	private CityMasterRepository cityRepo;
	
	
	@Override
	public Map<Integer,String> getAllCountries() {
		Map<Integer,String> countryMap = new LinkedHashMap<>();
		
		List<CountryMasterEntity> countriesList = cmRepo.findAll();
		countriesList.forEach(Country->{
				countryMap.put(Country.getCountryId(),Country.getCountryName());
		});
		return countryMap;
	}

	@Override
	public Map<Integer, String> getStatesByCountryId(Integer cid) {
		
		Map<Integer,String> stateMap = new LinkedHashMap<>();
		
		List<StateMasterEntity> findState = smRepo.findAllByCountryId(cid);
		
		findState.forEach(entity->{
			stateMap.put(entity.getStateId(),entity.getStateName());
		});
		return stateMap;
	}
	
	@Override
	public Map<Integer, String> getCityByStateId(Integer sid) {
		 Map<Integer,String> cityMap = new LinkedHashMap<>();
		 List<CityMasterEntity> allCities = cityRepo.findAllByStateId(sid);
		 allCities.forEach(entity->{
			 cityMap.put(entity.getCityId(), entity.getCityName());
		 });
		return cityMap;
	}
	
	@Override
	public boolean saveUserAcc(UserAccountsEntity uae) {
		uae.setActiveStatus('L');
		uae.setPazzword(TempPasswordGenarator.randomAlphaNumericPass(6));// here 6 means 6 digits password
		UserAccountsEntity isSaved = uaRepo.save(uae);
		if(isSaved==null)
			return false;
		else			
		    return true;
	}
	@Override
	public UserAccountsEntity emailValidation(String email) {
		UserAccountsEntity emailExisted = uaRepo.findAllByEmail(email);
		if(emailExisted==null) {
			return null;
		}
		return emailExisted;
	}
	
	
	//to check temp password is valid or not
	@Override
	public boolean isTempPassValid(String pazzword) {
		UserAccountsEntity findByPazzword = uaRepo.findByPazzword(pazzword);
		if(findByPazzword!=null)
			return true;
		else
			return false;
	}
	public boolean updateUserAccLockAndPass(UserAccountsEntity uae) {
		UserAccountsEntity isSaved = uaRepo.save(uae);
		if(isSaved==null)
			return false;
		else			
		    return true;
	}
	
	
}
