package com.test.service;

public interface UserService {

    public String getUserInfo();

    //public String getTableData(Map<String, Object> map);

    public String getTableData(String time, String pageno, String pagesize);


}
