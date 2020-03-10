package com.test.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.Mapper;

import com.test.model.TestModel;

@Mapper("userMapper")
public interface UserMapper {

    public String getUserInfo();

    public List<TestModel> getTableData(@Param("map") Map<String, Object> map);

    public int getTableSum(@Param("map") Map<String, Object> map);

}
