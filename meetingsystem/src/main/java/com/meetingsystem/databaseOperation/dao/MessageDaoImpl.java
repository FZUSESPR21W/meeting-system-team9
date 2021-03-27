package com.meetingsystem.databaseOperation.dao;

import com.meetingsystem.databaseOperation.model.Message;
import com.meetingsystem.databaseOperation.model.User;

import java.util.List;

/**
 * @author 221801318_黄贸之
 * @Date 2021/3/27
 */
public class MessageDaoImpl implements BaseCURD<Message> {

    @Override
    public int create(Message dataClass) {
        String sql="insert into message(userId,forumId,time,content) values(?,?,?,?)";
        Object[] paramsValue={dataClass.getUserId(), dataClass.getForumId(), dataClass.getTime(), dataClass.getContent()};
        baseDao.update(sql,paramsValue);
        return -1;
    }

    @Override
    public void delete(Object[] key) {
        String sql="delete from paper where id=?";
        baseDao.update(sql,key);
    }

    @Override
    public void update(String[] propertyName, Object[] value) {

    }

    @Override
    public List<Message> readByKey(String[] propertyName, Object[] value) {
        String head="select * from message";
        if (propertyName.length<1){
            List<Message> messageList=baseDao.query(head,value,Message.class);
            return messageList.size()>0?messageList:null;
        } else {
            head=head+" where ";
        }
        String sql=head;

        int count=propertyName.length;
        //填入各个属性
        for(int i=0;i<count;i++)
        {
            if(i==0)
                sql=sql+propertyName[i]+"=?";
            else
                sql=sql+" and "+propertyName[i]+"=?";
        }

        List<Message> messageList=baseDao.query(sql,value,Message.class);
        return messageList.size()>0?messageList:null;
    }
}
