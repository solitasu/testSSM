package com.test.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
@RequestMapping("/file")
public class UpLoadFile {

    @RequestMapping("/upload.do")
    public String upload(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        // 这里我用到了jar包
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                MultipartFile file = multiRequest.getFile((String) iter.next());
                if (file != null) {
                    String fileName = file.getOriginalFilename();

                    String path1 = Thread.currentThread()
                            .getContextClassLoader().getResource("").getPath()
                            + "download" + File.separator;

                    //  下面的加的日期是为了防止上传的名字一样
                    String path = path1
                            + new SimpleDateFormat("yyyyMMddHHmmss")
                            .format(new Date()) + fileName;

                    File localFile = new File(path);

                    file.transferTo(localFile);
                }

            }

        }
        return "uploadSuccess";

    }
}
