package com.meetingsystem.databaseOperation.dao;

import com.meetingsystem.databaseOperation.model.User;
import com.meetingsystem.databaseOperation.model.UserForum;

import java.util.List;

public class UserForumDaoImpl implements BaseCURD<UserForum> {

    @Override
    public int create(UserForum dataClass) {
        String sql="insert into userforum(userId,forumId) values(?,?)";
        Object[] paramsValue={dataClass.getUserid(), dataClass.getForumid()};
        baseDao.update(sql,paramsValue);
        return -1;
    }

    @Override
    public void delete(Object[] key) {

    }

    @Override
    public void update(String[] propertyName, Object[] value) {

    }

    @Override
    public List<UserForum> readByKey(String[] propertyName, Object[] value) {
        String head="select * from userforum";
        if (propertyName.length<1){
            List<UserForum> userForumList=baseDao.query(head,value,UserForum.class);
            return userForumList.size()>0?userForumList:null;
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

        List<UserForum> userForumList=baseDao.query(sql,value,UserForum.class);
        return userForumList.size()>0?userForumList:null;
    }
}
