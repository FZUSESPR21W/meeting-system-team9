package com.meetingsystem.service.user;

import com.meetingsystem.databaseOperation.dao.UserDaoImpl;
import com.meetingsystem.databaseOperation.model.User;
import com.meetingsystem.databaseOperation.encryption.MD5Util;

import java.util.ArrayList;
import java.util.List;

public class UserService {
	
	UserDaoImpl userDaoImpl = new UserDaoImpl();
	
	public Boolean login(User user) {
		List<User> readData = userDaoImpl.readByKey(new String[] {"userid"},new Object[] {user.getUserid()});
		if(readData==null||readData.size()<=0) {
			return false;
		}
		if(!readData.get(0).getPassword().equals(MD5Util.md5Password(user.getPassword()))) {
				return false;
		}
		return true;
	}
	
}
