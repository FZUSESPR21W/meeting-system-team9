package com.meetingsystem.controller;

import com.meetingsystem.databaseOperation.model.Forum;
import com.meetingsystem.databaseOperation.model.User;
import com.meetingsystem.service.forum.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/forum")
public class ForumController {

    @Autowired
    private ForumService forumService;


    @GetMapping("/all")
    public List<Forum> returnAll(){
        return forumService.getAllForum();
    }

    @GetMapping("/searchbyuser")
    public List<Forum> searchByName(User user){
        return forumService.getForumByUser(user);
    }


}
