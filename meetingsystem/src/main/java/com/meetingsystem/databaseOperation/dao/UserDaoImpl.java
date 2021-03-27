package com.meetingsystem.databaseOperation.dao;

import com.meetingsystem.databaseOperation.model.User;

import java.util.List;

/**
 * @author 221801318_黄贸之
 * @Date 2021/3/27
 */
public class UserDaoImpl implements BaseCURD<User>{

    @Override
    public int create(User dataClass) {
        String sql="insert into user(userId,password,role) values(?,?,?)";
        Object[] paramsValue={dataClass.getUserid(), dataClass.getPassword(), dataClass.getRole()};
        baseDao.update(sql,paramsValue);
        return -1;
    }

    @Override
    public void delete(Object[] key) {

    }

    @Override
    public void update(String[] propertyName, Object[] value) {

    }

    /**
     * Paper表查询数据
     *
     * @param propertyName 查询字段名，顺序与value一致
     * @param value 查询字段值，顺序与propertyName一致
     * @return Paper列表
     */
    @Override
    public List<User> readByKey(String[] propertyName, Object[] value) {
        String head="select * from user";
        if (propertyName.length<1){
            List<User> userList=baseDao.query(head,value,User.class);
            return userList.size()>0?userList:null;
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

        List<User> userList=baseDao.query(sql,value,User.class);
        return userList.size()>0?userList:null;
    }
}
