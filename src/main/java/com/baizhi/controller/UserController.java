package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    public @ResponseBody HashMap<String,Object> regist(User user){
        user.setId(UUID.randomUUID().toString());
        userService.add(user);
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

    @RequestMapping("/login")
    public @ResponseBody String login(User user){
        User log = userService.login(user);
        if(log!=null){
            return "100101";
        }else{
            return null;
        }
    }
    @RequestMapping("/upd")
    public void updates(User user){
        userService.update(user);
    }
}
