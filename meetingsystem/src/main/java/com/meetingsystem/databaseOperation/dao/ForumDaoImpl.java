package com.meetingsystem.databaseOperation.dao;

import com.meetingsystem.databaseOperation.model.Forum;
import com.meetingsystem.databaseOperation.model.Meeting;

import java.util.List;

/**
 * @author 221801318_黄贸之
 * @Date 2021/3/27
 */
public class ForumDaoImpl implements BaseCURD<Forum>{
    @Override
    public int create(Forum dataClass) {
        String sql="insert into forum(name,masterId,title) values(?,?,?)";
        Object[] paramsValue={dataClass.getName(), dataClass.getMasterId(), dataClass.getTitle()};
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
    public List<Forum> readByKey(String[] propertyName, Object[] value) {
        String head="select * from forum";
        if (propertyName.length<1){
            List<Forum> forumList=baseDao.query(head,value,Forum.class);
            return forumList.size()>0?forumList:null;
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

        List<Forum> forumList=baseDao.query(sql,value,Forum.class);
        return forumList.size()>0?forumList:null;
    }



}
