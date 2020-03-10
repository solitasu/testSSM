package com.test.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.test.model.TestModel;

public interface DatabaseService {

    public void getInDatabase(Map<String, Object> dataBase);

    public String getAcquireData();

    /**
     * 下拉框模糊查询
     *
     * @return
     */
    public List<TestModel> getselectData();

    /**
     * @param file
     * @param request
     * @description 上传文件
     */
    public String upLoadingFiles(MultipartFile file, HttpServletRequest request);

    /**
     * @param response
     * @param request
     * @param fileName
     * @description 下载文件
     */
    public void downFiles(HttpServletRequest request, HttpServletResponse response, String fileName) throws IOException;

}
