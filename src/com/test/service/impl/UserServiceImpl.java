package com.test.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.test.dao.UserDao;
import com.test.model.TestModel;
import com.test.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public String getUserInfo() {

        return userDao.getUserInfo();
    }

    /**
     * 表格数据
     *
     * @return
     */
    @Override
    public String getTableData(String time, String pageno, String pagesize) {
        int pageIndex = Integer.parseInt(pageno);
        int pageTotal = Integer.parseInt(pagesize);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("time", time);
        map.put("pageno", (pageIndex - 1) * pageTotal + "");
        map.put("pagesize", pagesize);
        //总数
        int sum = userDao.getTableSum(map);
        //数据
        List<TestModel> data = userDao.getTableData(map);
        Map<String, Object> allData = new HashMap<String, Object>();
        allData.put("sum", sum);
        allData.put("data", data);
        return new Gson().toJson(allData);
    }

}
