package com.test.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.test.dao.DatabaseDao;
import com.test.mapper.DatabaseMapper;
import com.test.model.TestModel;

@Repository
public class DatabaseDaoImpl implements DatabaseDao {

    @Resource
    private DatabaseMapper databaseMapper;

    @Override
    public void getInDatabase(Map<String, Object> dataBase) {
        // TODO Auto-generated method stub
        databaseMapper.getInDatabase(dataBase);
        System.out.println("dao");
    }

    @Override
    public String getAcquireData() {
        // TODO Auto-generated method stub
        return databaseMapper.getAcquireData();
    }

    /**
     * 下拉框模糊查询
     *
     * @return
     */
    @Override
    public List<TestModel> getselectData() {
        return databaseMapper.getselectData();
    }

}
