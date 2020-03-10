package com.test.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.test.model.TestModel;
import com.test.service.DatabaseService;

@Controller
@RequestMapping("/database")
public class Database {

    @Resource
    private DatabaseService databaseService;

    /**
     * 向数据库插入数据
     * http://localhost:8080/testSSM/database/getInsertDatabase.do?username=%E5%95%8A%E5%95%8A&age=11&password=1111
     *
     * @param age
     * @param username
     * @param password
     */
    @RequestMapping(value = "/getInsertDatabase", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getInsertDatabase(@RequestParam(value = "age") String age,
                                    @RequestParam(value = "username") String username,
                                    @RequestParam(value = "password") String password) {
        Map<String, Object> dataBase = new HashMap<String, Object>();   //map存储数据
        dataBase.put("age", Integer.parseInt(age));   //将age从string格式转化为int格式
        dataBase.put("username", username);
        dataBase.put("password", password);
        System.out.println("成功" + age + username + password);
        databaseService.getInDatabase(dataBase);   //向service层传送数据
        Gson gson = new Gson();
        return gson.toJson("成功");   //向前台返回数据
    }

    /**
     * 向数据库获取数据
     *
     * @return
     */
    @RequestMapping(value = "/getAcquireData", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getAcquireData() {
        System.out.println(databaseService.getAcquireData());
        String acquireData = databaseService.getAcquireData();
        Gson gson = new Gson();
        return gson.toJson(acquireData);
    }

    /**
     * 下拉框模糊查询
     *
     * @return
     */
    @RequestMapping(value = "/getselectData", produces = "application/json;charset=utf-8")
    @ResponseBody
    private List<TestModel> getselectData() {
        return databaseService.getselectData();
    }

    /**
     * @param file
     * @param request
     * @description 上传文件
     */
    @RequestMapping(value = "/upLoadingFiles.do")
    @ResponseBody
    public String upLoadingFiles(MultipartFile file, HttpServletRequest request) {
        return databaseService.upLoadingFiles(file, request);
    }

    /**
     * @param response
     * @param request
     * @description 下载文件
     */
    @RequestMapping(value = "/downFiles.do")
    @ResponseBody
    public void downFiles(HttpServletRequest request, HttpServletResponse response, String fileName) throws IOException {
        databaseService.downFiles(request, response, fileName);
    }


}
