package com.nt.service;

import java.util.Map;

import com.nt.entities.UserAccountsEntity;

public interface UserManagementService {
	
	public Map<Integer,String> getAllCountries();
	public Map<Integer,String> getStatesByCountryId(Integer cid);
	public Map<Integer,String> getCityByStateId(Integer sid);
	public boolean saveUserAcc(UserAccountsEntity ua);
	public UserAccountsEntity emailValidation(String email);
	public boolean isTempPassValid(String pazzword);
	public boolean updateUserAccLockAndPass(UserAccountsEntity uae);

}
