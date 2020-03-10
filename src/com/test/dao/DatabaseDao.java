package com.test.dao;

import java.util.List;
import java.util.Map;

import com.test.model.TestModel;

public interface DatabaseDao {

    public void getInDatabase(Map<String, Object> dataBase);

    public String getAcquireData();

    /**
     * 下拉框模糊查询
     *
     * @return
     */
    public List<TestModel> getselectData();

}
