package com.test.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.test.dao.UserDao;
import com.test.mapper.UserMapper;
import com.test.model.TestModel;

@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private UserMapper userMapper;

    @Override
    public String getUserInfo() {
        return userMapper.getUserInfo();
    }

    @Override
    public List<TestModel> getTableData(Map<String, Object> map) {
        return userMapper.getTableData(map);
    }

    @Override
    public int getTableSum(Map<String, Object> map) {
        return userMapper.getTableSum(map);
    }

}
