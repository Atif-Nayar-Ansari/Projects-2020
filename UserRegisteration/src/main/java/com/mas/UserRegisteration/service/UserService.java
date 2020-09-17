package com.mas.UserRegisteration.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mas.UserRegisteration.domin.City;
import com.mas.UserRegisteration.domin.Country;
import com.mas.UserRegisteration.domin.State;
import com.mas.UserRegisteration.domin.User;
import com.mas.UserRegisteration.model.CityEntity;
import com.mas.UserRegisteration.model.CountryEntity;
import com.mas.UserRegisteration.model.StateEntity;
import com.mas.UserRegisteration.model.UserEntity;
import com.mas.UserRegisteration.repository.CityRepository;
import com.mas.UserRegisteration.repository.CountryRepository;
import com.mas.UserRegisteration.repository.StateRepository;
import com.mas.UserRegisteration.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private CityRepository cityRepository;

	public Boolean saveUser(User user) {
		System.out.println(user);
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		UserEntity entity = userRepository.save(userEntity);
		System.out.println(entity);
		return entity != null;

	}


	public List<Country> getAllCountry() {

		List<Country> listCountry = new ArrayList();
		List<CountryEntity> findAll = countryRepository.findAll();
		for (CountryEntity con : findAll) {
			Country country = new Country();
			BeanUtils.copyProperties(con, country);
			listCountry.add(country);
		}
		return listCountry;
	}
	
	public List<State> getAllState(Integer countryId) {
		List<State> listState = new ArrayList();
		List<StateEntity> findAllByCountryId = stateRepository.findAllByCountryId(countryId);
		for (StateEntity liststate : findAllByCountryId) {
			State state = new State();
			BeanUtils.copyProperties(liststate, state);
			listState.add(state);
		}

		return listState;
	}

	

	public List<City> getAllCity(Integer stateId) {
		List<City> listCitys = new ArrayList();
		List<CityEntity> findAllByCityId = cityRepository.findAllByStateId(stateId);
		for (CityEntity listCity : findAllByCityId) {
			City city = new City();
			BeanUtils.copyProperties(listCity, city);
			listCitys.add(city);
		}
		return listCitys;
	}


	public Boolean checkEmail(String email) {
		Boolean checkEmail = userRepository.checkEmail(email);
		return checkEmail;
		// TODO Auto-generated method stub
		
	}

}
