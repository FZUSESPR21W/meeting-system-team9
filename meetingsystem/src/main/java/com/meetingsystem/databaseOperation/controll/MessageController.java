package com.meetingsystem.databaseOperation.controller;

import com.meetingsystem.databaseOperation.model.Message;
import com.meetingsystem.service.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/all")
    public List<Message> getAllMessages(String userId, String forumName){
        List<Message> messages = messageService.getAllMessages(userId, forumName);
        return messages;
    }

    @PostMapping("/add")
    public Boolean addMessage(Message message){
        Boolean result = messageService.addMessage(message);
        return result;
    }
}
