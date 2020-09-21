package com.yanjiuyuan.videowork.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

import com.yanjiuyuan.videowork.entity.UserBean;
import com.yanjiuyuan.videowork.service.InserNameService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@Controller
public class RegisterController {
    @Autowired
    InserNameService insernameservice;
@Autowired
JdbcTemplate jdbcTemplate;
    @GetMapping("/jdbc")
    @ResponseBody
    @RequestMapping("/RegisterUser")
    public String show(){
        return "RegisterUser";
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
   public String userregister(HttpServletRequest request, HttpSession session)
   {
       String Username=request.getParameter("ReUsername");
       System.out.println(Username);
       String Userpwd=request.getParameter("ReUserpwd");
       String sql="select Username from videousers where Username=?";
       String userresult=null;
       try{
           userresult=jdbcTemplate.queryForObject(sql, java.lang.String.class,Username);
       }catch (EmptyResultDataAccessException e)
       {
           userresult=null;
       }

       if(userresult ==null || userresult=="")
       {
           session.setAttribute("ReUsername",Username);
           insernameservice.Insertuser(Username,Userpwd);
           return "loginRegister";

       }
       else
       {
           /*session.setAttribute("ReUsername","");
           String  va1= (String) session.getAttribute("ReUsername");*/

          return "RegisterUser";
       }
   }

    /*public boolean checkname(String Username)
    {
        boolean flag = false;
        String sql="select Username from videousers where Username="+Username;
        String userresult=(String)jdbcTemplate.queryForObject(sql, java.lang.String.class);
        if(userresult ==null || userresult=="")
        {
            flag=true;
        }
        else
        {
            flag=false;
        }
        return flag;
    }*/
}
