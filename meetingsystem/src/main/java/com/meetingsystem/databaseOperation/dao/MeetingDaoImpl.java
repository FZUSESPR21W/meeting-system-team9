package com.meetingsystem.databaseOperation.dao;

import com.meetingsystem.databaseOperation.model.Meeting;
import com.meetingsystem.databaseOperation.model.Message;

import java.util.List;

/**
 * @author 221801318_黄贸之
 * @Date 2021/3/27
 */
public class MeetingDaoImpl implements BaseCURD<Meeting> {

    @Override
    public int create(Meeting dataClass) {
        return 0;
    }

    @Override
    public void delete(Object[] key) {

    }

    @Override
    public void update(String[] propertyName, Object[] value) {

    }

    @Override
    public List<Meeting> readByKey(String[] propertyName, Object[] value) {
        String head="select * from meeting";
        if (propertyName.length<1){
            List<Meeting> meetingList=baseDao.query(head,value,Meeting.class);
            return meetingList.size()>0?meetingList:null;
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

        List<Meeting> meetingList=baseDao.query(sql,value,Meeting.class);
        return meetingList.size()>0?meetingList:null;
    }

}
