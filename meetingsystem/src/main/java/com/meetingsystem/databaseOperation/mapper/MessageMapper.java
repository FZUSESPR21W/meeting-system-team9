package com.meetingsystem.mapper;

import com.meetingsystem.databaseOperation.model.Message;

import java.util.List;

public interface MessageMapper {
    public Boolean addMessage(Message message);

    public List<Message> getAllMessages(String userId, String forumName);


}
