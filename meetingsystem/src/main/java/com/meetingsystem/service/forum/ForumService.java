package com.meetingsystem.service.forum;

import com.meetingsystem.databaseOperation.model.*;
import com.meetingsystem.databaseOperation.dao.*;

import java.util.ArrayList;
import java.util.Iterator;

import java.util.List;

public class ForumService {
	public List<Forum> getForumByUser(User user) {
		BaseCURD<UserForum> userForumBase = new UserForumDaoImpl();
		BaseCURD<Forum> forumBase = new ForumDaoImpl();
		List<UserForum> userForumList = userForumBase.readByKey(new String[]{"userid"}, new Object[]{user.getId()});
		List<Forum> forumList, tmpList;
		forumList = new ArrayList<Forum>();
		for (int i = 0, size = userForumList.size(); i < size; i++) {
			UserForum tmp = userForumList.get(i);
			tmpList = forumBase.readByKey(new String[] {"id"}, new Object[] {tmp.getForumid()});
			forumList.add(tmpList.get(0));
	    }
		return forumList;
	}
	
	public Forum getForumByName(String forumName) {
    	BaseCURD<Forum> forumBase = new ForumDaoImpl();
    	Forum forum = forumBase.readByKey(new String[] {"name"}, new Object[] {forumName}).get(0);
		return forum;
	}
	
    public List<User> getForumUserByName(String forumName) {
    	BaseCURD<Forum> forumBase = new ForumDaoImpl();
    	Forum forum = forumBase.readByKey(new String[] {"name"}, new Object[] {forumName}).get(0);
    	UserService userService = new UserService();
		return getAllUser(forum);
	}
	
    public void joinForum(User user) {
		
	}
    
    public List<Forum> getAllForum(User user) {
		
		return ;
	}
    
}
