package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("/add")
    public @ResponseBody Map<String,Object> Insert(Banner banner, HttpServletRequest request, MultipartFile imagePath) throws IOException {

        String realPath=request.getSession().getServletContext().getRealPath("photo/bannerPic");
        imagePath.transferTo(new File(realPath,imagePath.getOriginalFilename()));
        banner.setImgPath(imagePath.getOriginalFilename());
        HashMap<String, Object> results = new HashMap<String,Object>();
        try {
          bannerService.add(banner);
            results.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

    @RequestMapping("/All")
    public @ResponseBody List<Banner> FindAll(){
        List<Banner> all = bannerService.findAll();
        for (Banner banner : all) {
        }
        return all;
    }

    //修改
    @RequestMapping("/motify")
    public @ResponseBody void Updates(Banner banner,HttpServletRequest request, MultipartFile imagePath) throws IOException {
        String realPath=request.getSession().getServletContext().getRealPath("photo/bannerPic");
        imagePath.transferTo(new File(realPath,imagePath.getOriginalFilename()));
        banner.setImgPath(imagePath.getOriginalFilename());
        bannerService.motify(banner);
    }

    //根据id查询
    @RequestMapping("/findOne")
    public @ResponseBody Banner FindOne(int id){
        return bannerService.findOne(id);
    }

    @RequestMapping("/remove")
    public  @ResponseBody void delete(int id){
        bannerService.remove(id);
    }

}
