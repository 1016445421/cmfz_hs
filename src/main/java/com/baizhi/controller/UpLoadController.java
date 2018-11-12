package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

@Controller
@RequestMapping("/upLoad")
public class UpLoadController {
    @RequestMapping("/download")
    public void download(String fileName,String openStyle,HttpServletRequest request,HttpServletResponse response) throws Exception{

        //1.根据接收的文件名去服务中指定目录读取文件
        String realPath = request.getSession().getServletContext().getRealPath("/photo/mv");
        //2.以文件输入流读取文件
        FileInputStream is = new FileInputStream(new File(realPath,fileName));
        //2.1 设置响应头
        response.setHeader("content-disposition", openStyle+";fileName="+URLEncoder.encode(fileName, "UTF-8"));
        //3.获取响应输出流
        ServletOutputStream os = response.getOutputStream();
        //4.使用IOUtils工具类
        IOUtils.copy(is, os);
        //5.关流
        IOUtils.closeQuietly(is);//安静关流
        IOUtils.closeQuietly(os);

    }
}
