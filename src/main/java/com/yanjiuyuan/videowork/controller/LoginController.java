package com.yanjiuyuan.videowork.controller;
import com.yanjiuyuan.videowork.serviceImpl.UsernameServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.yanjiuyuan.videowork.entity.UserBean;
import com.yanjiuyuan.videowork.service.UserService;
import com.yanjiuyuan.videowork.service.UsernameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Controller
public class LoginController {
    //将service注入web
    @Autowired
    UserService userservice;
    @Autowired
    UsernameService usernameservice;

    @RequestMapping("/login")
        public String show(){
        return "login";
    }
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String userlogin(HttpServletRequest request, HttpSession session)
    {
        String Username=request.getParameter("Username");
        String Userpwd=request.getParameter("Userpwd");
        session.setAttribute("Username",Username);
        UserBean userbean = userservice.loginIn(Username,Userpwd);
        UserBean getnameinfo=usernameservice.loginName(Username);
        if(getnameinfo!=null)
        {
            if(userbean !=null && "Admin".equals(Username))
            {
                return "redirect:AdminPage" ;
            }
            if (userbean !=null && !"Admin".equals(Username))
            {
                return "redirect:GeneralUserPage";
            }
            else
            {
                return "loginerror";
            }
        }
        else {
            if(Username!="")
            {
                return "RegisterUser";
            }
            else
            {return "RegisterFrombutton";}

        }

    }
        /*public String login(String Username,String Userpwd)
    {
        UserBean userbean=userservice.loginIn(Username,Userpwd);

        if(userbean !=null)
        {
            return "success" ;
        }
        else
        {
            return "error";
        }
    }*/
}
