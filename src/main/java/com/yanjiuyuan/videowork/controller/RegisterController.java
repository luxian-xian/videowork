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
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping("/RegisterUser")
    public String show(){
        return "RegisterUser";
    }
        @RequestMapping(value = "/RegisterUser",method = RequestMethod.POST)
   // @ResponseBody
   public String RegisterUser(HttpServletRequest request,HttpServletResponse response )
                throws ServletException, IOException{
       String ReUsername=request.getParameter("ReUsername");
       System.out.println("前台UI的值"+ReUsername);
       String ReUserpwd=request.getParameter("ReUserpwd");
       String sql="select Username from videousers where Username=?";
       String userresult=null;
       boolean flag=true;
       try{
           userresult=jdbcTemplate.queryForObject(sql, java.lang.String.class,ReUsername);
       }catch (EmptyResultDataAccessException e)
       {
           userresult=null;
       }

       if(userresult ==null || userresult=="")
       {

          response.getWriter().println("<!--usernotexist-->");//不存在用户名
           if(ReUserpwd!=null ) {
               insernameservice.Insertuser(ReUsername, ReUserpwd);
           }
           return "loginRegister";
       }
       else
       {
           //session.setAttribute("ReUsername","");
         //  String  va1= (String) session.getAttribute("ReUsername");
           response.getWriter().println("<!--userexist-->");//存在该用户

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

