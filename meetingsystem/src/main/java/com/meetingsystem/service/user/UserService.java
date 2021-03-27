package com.meetingsystem.service.user;

import com.meetingsystem.databaseOperation.dao.UserDaoImpl;
import com.meetingsystem.databaseOperation.model.User;
import com.meetingsystem.databaseOperation.encryption.MD5Util;

import java.util.ArrayList;
import java.util.List;
import com.meetingsystem.databaseOperation.model.UserForum;
import com.meetingsystem.databaseOperation.model.Forum;
import com.meetingsystem.databaseOperation.dao.UserForumDaoImpl;

public class UserService {
	
	UserDaoImpl userDaoImpl = new UserDaoImpl();
	UserForumDaoImpl userForumDaoImpl = new UserForumDaoImpl();
	
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
	
	public Boolean sign(User user) {
		List<User> readData = userDaoImpl.readByKey(new String[] {"userid"},new Object[] {user.getUserid()});
		if(readData.size()>0) {
			return false;
		}
		
		userDaoImpl.create(user);
		return true;
	}
	
	public List<User> getAllUser(Forum f) {
		List<UserForum> readData = userForumDaoImpl.readByKey(new String[] {"forumid"},new Object[] {f.getId()});
		List<User> readData2=new ArrayList<User>();
		for(int i=0;i<readData.size();i++) {
			readData2.add(userDaoImpl.readByKey(new String[] {"id"},new Object[] {readData.get(i).getId()}).get(0))  ;
		}
		return readData2;
		
	}
}
