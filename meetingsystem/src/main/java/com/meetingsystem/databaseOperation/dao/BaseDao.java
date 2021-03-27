package com.meetingsystem.databaseOperation.dao;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author 221801318_黄贸之
 * @Date 2021/3/27
 */
public interface BaseDao {
    //日志信息
    static Logger logger=Logger.getLogger(BaseDao.class.getName());

    //数据更新接口
    public int update(String sql,Object[] paramsValue);
    //数据查询接口
    public <T> List<T> query(String sql, Object[] paramsValue, Class<T> cla);
}
