package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    //登陆
    @RequestMapping("/login")
    public String login(Admin adm, HttpSession session, String enCode) {
        String validationCode = (String) session.getAttribute("validationCode");
        if (validationCode.equals(enCode)) {
            Admin login = adminService.login(adm);
            if (login != null) {
                session.setAttribute("session", login);
                return "redirect:/xiangguan/main/main.jsp";
            }
            return "redirect:/xiangguan/login.jsp";
        }
        return "redirect:/xiangguan/login.jsp";
    }

    //退出
    @RequestMapping("/over")
    public String Over(HttpSession session){
        session.setAttribute("session",null);
        return "xiangguan/login";
    }

    @RequestMapping("/upd")
    public void update(String password1,HttpServletRequest request){
        HttpSession session = request.getSession();
        Admin session1 = (Admin)session.getAttribute("session");
        if(!session1.getPassword().equals(password1)){
            Admin admin2 = new Admin();
            admin2.setName(session1.getName());
            admin2.setId(session1.getId());
            admin2.setPassword(password1);
            adminService.update(admin2);
        }
    }

}