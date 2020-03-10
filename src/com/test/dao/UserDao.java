package com.test.dao;

import java.util.List;
import java.util.Map;

import com.test.model.TestModel;

public interface UserDao {

    public String getUserInfo();

    public List<TestModel> getTableData(Map<String, Object> map);

    public int getTableSum(Map<String, Object> map);

}
