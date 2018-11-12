package com.baizhi.controller;


import com.baizhi.entity.Chapter;

import com.baizhi.service.ChapterService;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.DecimalFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/All")
    public @ResponseBody
    List<Chapter> FindAll() {
        List<Chapter> all = chapterService.findAll();
        return all;
    }

    @RequestMapping("/add")
    public @ResponseBody
    HashMap<Object, Object> Insert(Chapter chapter, HttpServletRequest request, MultipartFile downsPath) throws Exception {

        String realPath = request.getSession().getServletContext().getRealPath("photo/mv");
        Long sizes = downsPath.getSize();
        double v = sizes / 1024.0 / 1024.0;
        DecimalFormat df = new DecimalFormat();

        chapter.setId(UUID.randomUUID().toString());
        chapter.setSizes(df.format(v)+"MB");
        chapter.setDownPath(downsPath.getOriginalFilename());

        downsPath.transferTo(new File(realPath, downsPath.getOriginalFilename()));

        File file = new File(realPath, downsPath.getOriginalFilename());
        MP3File f = (MP3File) AudioFileIO.read(file);

        MP3AudioHeader audioHeader = (MP3AudioHeader) f.getAudioHeader();
        String trackLength = audioHeader.getTrackLength() / 360 + ":" + audioHeader.getTrackLength() / 60 + ":" + audioHeader.getTrackLength() % 60;
        chapter.setDuration(trackLength);
        chapter.setUpLoadTime(new Date());
        chapterService.add(chapter);

        HashMap<Object, Object> results = new HashMap<>();
        try {
            results.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success", false);
            results.put("message", e.getMessage());
        }
        return results;
    }
}



