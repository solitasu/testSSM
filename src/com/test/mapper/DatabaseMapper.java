package com.test.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.Mapper;

import com.test.model.TestModel;

@Mapper("databaseMapper")
public interface DatabaseMapper {

    public void getInDatabase(@Param("map") Map<String, Object> map);

    public String getAcquireData();

    /**
     * 下拉框模糊查询
     *
     * @return
     */
    public List<TestModel> getselectData();
}
