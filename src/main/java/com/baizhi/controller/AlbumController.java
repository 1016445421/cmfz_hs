package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("/add")
    public @ResponseBody Map<String,Object> Insert(Album album, HttpServletRequest request, MultipartFile coveringPath) throws IOException {
        String realPath=request.getSession().getServletContext().getRealPath("photo/mv");
        coveringPath.transferTo(new File(realPath,coveringPath.getOriginalFilename()));
        album.setCovering(coveringPath.getOriginalFilename());
        album.setId(UUID.randomUUID().toString());
        album.setPublishDate(new Date());
        albumService.add(album);

        HashMap<String, Object> results = new HashMap<String,Object>();
        try {
            results.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

    @RequestMapping("/All")
    public @ResponseBody List<Album> FindAll(){
        List<Album> all = albumService.findAll();
        return all;
    }

    //根据id查询
    @RequestMapping("/findOne")
    public @ResponseBody Album FindOne(String id){
        return albumService.findOne(id);
    }

}
