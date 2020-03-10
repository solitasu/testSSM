package com.test.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.test.dao.DatabaseDao;
import com.test.model.TestModel;
import com.test.service.DatabaseService;

@Service("databaxeServiceImpl")
public class DatabaxeServiceImpl implements DatabaseService {

    @Resource
    private DatabaseDao databaseDao;

    @Override
    public void getInDatabase(Map<String, Object> dataBase) {
        // TODO Auto-generated method stub
        databaseDao.getInDatabase(dataBase);
        System.out.println("service");
    }

    @Override
    public String getAcquireData() {
        // TODO Auto-generated method stub
        return databaseDao.getAcquireData();
    }

    /**
     * 下拉框模糊查询
     *
     * @return
     */
    @Override
    public List<TestModel> getselectData() {
        return databaseDao.getselectData();
    }

    /**
     * @param file
     * @param request
     * @description 上传文件
     */
    @Override
    public String upLoadingFiles(MultipartFile file, HttpServletRequest request) {
        //得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
        String savePath = "C:\\testSSMUpLoadFiles";
        File files = new File(savePath);
        //判断上传文件的保存目录是否存在
        if (!files.exists() && !files.isDirectory()) {
            System.out.println(savePath + "目录不存在，需要创建");
            //创建目录
            files.mkdirs();
        }
        //消息提示
        String filename = "";
        try {
            //使用Apache文件上传组件处理文件上传步骤：
            //1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //2、创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //解决上传文件名的中文乱码
            upload.setHeaderEncoding("UTF-8");
            //3、判断提交上来的数据是否是上传表单的数据
            if (!ServletFileUpload.isMultipartContent(request)) {
                //按照传统方式获取数据
                return "";
            }
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            String time = format.format(new Date());
            //得到上传的文件名称，
            filename = file.getOriginalFilename().trim();
            String[] names = filename.split("\\.");
            filename = names[0] + "__" + time;
            if (names.length > 1) {
                filename = filename + "." + names[1];
            }
            System.out.println(filename);
            //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
            //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
            filename = filename.substring(filename.lastIndexOf("\\") + 1);
            //获取item中的上传文件的输入流
            InputStream in = file.getInputStream();
            //创建一个文件输出流
            FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);
            //创建一个缓冲区
            byte buffer[] = new byte[1024];
            //判断输入流中的数据是否已经读完的标识
            int len = 0;
            //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
            while ((len = in.read(buffer)) > 0) {
                //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                out.write(buffer, 0, len);
            }
            //关闭输入流
            in.close();
            //关闭输出流
            out.close();
            System.out.println("文件上传成功！");
        } catch (Exception e) {
            System.out.println("文件上传失败！");
            e.printStackTrace();
        }
        return new Gson().toJson(filename);
    }

    /**
     * @param response
     * @param request
     * @description 下载文件
     */
    @Override
    public void downFiles(HttpServletRequest request, HttpServletResponse response, String fileName) throws IOException {
        //通过文件名找出文件的所在目录
        String path = "C:\\testSSMUpLoadFiles";
        fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");
        //得到要下载的文件
        File file = new File(path + "\\" + fileName);
        //如果文件不存在
        if (!file.exists()) {
            System.out.println(path + "\\" + fileName + "您要下载的资源已被删除！！");
        }
        //处理文件名
        String[] names = fileName.split("\\.");
        String realname = names[0].split("__")[0];
        if (names.length > 1) {
            realname = realname + "." + names[1];
        }
        //设置响应头，控制浏览器下载该文件
        String replaceAll = URLEncoder.encode(realname.trim(), "UTF-8").replaceAll("\\+", "%20").replaceAll("%28", "\\(").replaceAll("%29", "\\)").replaceAll("%3B", ";").replaceAll("%40", "@").replaceAll("%23", "\\#").replaceAll("%26", "\\&").replaceAll("%2C", "\\,");
        response.setHeader("content-disposition", "attachment;filename=" + replaceAll);
        //读取要下载的文件，保存到文件输入流
        FileInputStream in = new FileInputStream(path + "\\" + fileName);
        //创建输出流
        OutputStream out = response.getOutputStream();
        //创建缓冲区
        byte buffer[] = new byte[1024];
        int len = 0;
        //循环将输入流中的内容读取到缓冲区当中
        while ((len = in.read(buffer)) > 0) {
            //输出缓冲区的内容到浏览器，实现文件下载
            out.write(buffer, 0, len);
        }
        //关闭文件输入流
        in.close();
        //关闭输出流
        out.close();

    }

}
