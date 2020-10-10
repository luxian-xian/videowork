package com.yanjiuyuan.videowork.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class logoutController {
    @RequestMapping("/user/logout")
    public String Logout(HttpSession session)
    {
        //request.getSession().removeAttribute("uploadstatus");
        session.invalidate();
        return "login";

    }
}
