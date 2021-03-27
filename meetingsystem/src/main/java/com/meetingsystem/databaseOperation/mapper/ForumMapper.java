package com.meetingsystem.mapper;

import com.meetingsystem.databaseOperation.model.Forum;
import com.meetingsystem.databaseOperation.model.User;

import java.util.List;

public interface ForumMapper {

    public List<Forum> getForumByUser(User user) ;

    public Forum getForumByName(String forumName);

    public List<User> getForumUserByName(String forumName);

    public void joinForum(User user, String forumName);

    public List<Forum> getAllForum();




}
