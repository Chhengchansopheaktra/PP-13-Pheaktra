package com.hrd.services;

import java.util.List;

import com.hrd.model.Dashboard;
import com.hrd.model.User;


public interface UserService {

	public List<User> findAll();
	public List<User> findByUserHast(User user);
	public List<Dashboard> countGender();
	public boolean save(User user);
	public boolean deleteByUserHash(String userHash);
	public boolean updateByUserHash(User user);
	public boolean saveBatch(List<User> users);
	
}
