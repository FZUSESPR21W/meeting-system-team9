package com.meetingsystem.controller;

import com.meetingsystem.databaseOperation.model.Forum;
import com.meetingsystem.databaseOperation.model.User;
import com.meetingsystem.service.forum.ForumService;
import com.meetingsystem.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ForumService forumService;

    @GetMapping("/login")
    public User login(User user){
        return userService.login(user);
    }

    @GetMapping("/sign")
    public User sign(String[] temp){
        Forum forum = forumService.getForumByName(temp[2]);
        User usertemp = new User("",temp[0],temp[1],"用户");
        User user = userService.sign(usertemp);
        forumService.joinForum(user,forum.getName());
        return user;
    }



}
