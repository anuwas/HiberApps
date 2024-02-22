package com.ems.hib.dao;

import java.util.List;

import com.ems.hib.dto.UserMaster;

public interface UserMasterDAO {
	public List<UserMaster> userMasterList();
	public void addUserMaster(UserMaster userMaster);
	public void editUserMaster(UserMaster userMaster);
	public UserMaster getUserMaster(Long id);
	public void deleteUser(Long id);
	public void UserLogin(String username,String password);
	public UserMaster getUsreMasterByEmail(String email);
}
