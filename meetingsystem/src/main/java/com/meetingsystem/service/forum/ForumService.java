package com.meetingsystem.service.forum;

import com.meetingsystem.databaseOperation.model.*;
import com.meetingsystem.databaseOperation.dao.*;
import com.meetingsystem.service.user.UserService;

import java.util.ArrayList;
import java.util.Iterator;

import java.util.List;

public class ForumService {
	//根据用户获取其参与的全部论坛
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
	
	//根据论坛名获取论坛
	public Forum getForumByName(String forumName) {
    	BaseCURD<Forum> forumBase = new ForumDaoImpl();
    	Forum forum = forumBase.readByKey(new String[] {"name"}, new Object[] {forumName}).get(0);
		return forum;
	}
	
	//根据论坛名获取参加该论坛的用户列表
    public List<User> getForumUserByName(String forumName) {
    	BaseCURD<Forum> forumBase = new ForumDaoImpl();
    	Forum forum = forumBase.readByKey(new String[] {"name"}, new Object[] {forumName}).get(0);
    	UserService userService = new UserService();
		return userService.getAllUser(forum);
	}
	
    //注册时，用户加入论坛
    public void joinForum(User user, String forumName) {
    	Forum forum = getForumByName(forumName);
    	UserForum userForum =  new UserForum();
    	userForum.setUserid(user.getId());
    	userForum.setForumid(forum.getId());
	}
    
    //获取全部论坛的列表
    public List<Forum> getAllForum(User user) {
    	BaseCURD<Forum> forumBase = new ForumDaoImpl();
    	return forumBase.readByKey(new String[] {}, new Object[] {});
	}
    
}
