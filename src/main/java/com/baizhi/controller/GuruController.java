package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.entity.Guru;
import com.baizhi.service.BannerService;
import com.baizhi.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/guru")
public class GuruController {
    @Autowired
    private GuruService guruService;

    @RequestMapping("/add")
    public @ResponseBody Map<String,Object> Insert(Guru guru, HttpServletRequest request, MultipartFile headPicPath) throws IOException {

        String realPath=request.getSession().getServletContext().getRealPath("photo/teacher");
        headPicPath.transferTo(new File(realPath,headPicPath.getOriginalFilename()));
        guru.setHeadPic(headPicPath.getOriginalFilename());
        HashMap<String, Object> results = new HashMap<String,Object>();
        try {
             guruService.add(guru);
            results.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

    @RequestMapping("/All")
    public @ResponseBody List<Guru> FindAll(){
        List<Guru> all = guruService.findAll();
        return all;
    }

    //修改
    @RequestMapping("/motify")
    public @ResponseBody void Updates(Guru guru,HttpServletRequest request, MultipartFile headPicPath) throws IOException {
        String realPath=request.getSession().getServletContext().getRealPath("photo/teacher");
        headPicPath.transferTo(new File(realPath,headPicPath.getOriginalFilename()));
        guru.setHeadPic(headPicPath.getOriginalFilename());
        guruService.motify(guru);
    }

    //根据id查询
    @RequestMapping("/findOne")
    public @ResponseBody Guru FindOne(String id){
        return guruService.findOne(id);
    }

    @RequestMapping("/remove")
    public  @ResponseBody void delete(String id){
        guruService.remove(id);
    }

}
