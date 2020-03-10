package com.test.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.service.UserService;

@Controller
@RequestMapping("/userTest")
public class UserTest {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/userGetInfo")
    public String userGetInfo() {
        System.out.println("�ɹ�!!!");
        System.out.println(Integer.toBinaryString(6));
        String name = userService.getUserInfo();
        return name;
    }

    /**
     * 表格数据
     *
     * @return
     */
    @RequestMapping(value = "/getTableData.do")
    @ResponseBody
    //将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区，通常用来返回JSON数据或者是XML数据，需要注意的呢，在使用此注解之后不会再走试图处理器，而是直接将数据写入到输入流中
    public String getTableData(String time, String pageno, String pagesize) {
        String list = userService.getTableData(time, pageno, pagesize);
        return list;
    }

}
