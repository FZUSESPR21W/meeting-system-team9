package com.meetingsystem.service.message;

import com.meetingsystem.databaseOperation.dao.ForumDaoImpl;
import com.meetingsystem.databaseOperation.dao.MessageDaoImpl;
import com.meetingsystem.databaseOperation.dao.UserDaoImpl;
import com.meetingsystem.databaseOperation.dao.UserForumDaoImpl;
import com.meetingsystem.databaseOperation.model.Forum;
import com.meetingsystem.databaseOperation.model.Message;
import com.meetingsystem.databaseOperation.model.User;
import com.meetingsystem.databaseOperation.model.UserForum;

import java.util.ArrayList;
import java.util.List;

public class MessageService {
    MessageDaoImpl messageDaoImpl = new MessageDaoImpl();
    UserDaoImpl userDaoImpl = new UserDaoImpl();
    UserForumDaoImpl userForumDaoImpl = new UserForumDaoImpl();
    ForumDaoImpl forumDaoImpl = new ForumDaoImpl();

    public Boolean addMessage(Message message){
        int result = 0;
        result = messageDaoImpl.create(message);
        if (result == -1){
            return true;
        }
        else{
            return false;
        }
    }

    public List<Message> getAllMessages(String userId, String forumName){
        if (forumName.equals("")) {
            List<User> users = userDaoImpl.readByKey(new String[]{"userid"}, new Object[]{userId});
            List<UserForum> userForums = userForumDaoImpl.readByKey(new String[]{"userid"}, new Object[]{users.get(0).getId()});
            List<Message> messages = new ArrayList<>();
            for (UserForum userForum : userForums) {
                List<Message> temp = messageDaoImpl.readByKey(new String[]{"forumid"}, new Object[]{userForum.getForumid()});
                messages.addAll(temp);
            }
            return messages;
        }
        else {
            List<Forum> forums = forumDaoImpl.readByKey(new String[]{"name"}, new Object[]{forumName});
            List<Message> messages = messageDaoImpl.readByKey(new String[]{"forumid"}, new Object[]{forums.get(0).getId()});
            return messages;
        }
    }
}
