package com.meetingsystem.mapper;

import com.meetingsystem.databaseOperation.model.Forum;
import com.meetingsystem.databaseOperation.model.User;

import java.util.List;

public interface UserMapper {

    public User login(User user) ;

    public User sign(User user);

    public List<User> getAllUser(Forum f);
}
