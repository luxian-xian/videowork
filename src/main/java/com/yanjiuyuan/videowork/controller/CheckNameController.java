package com.yanjiuyuan.videowork.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

import com.yanjiuyuan.videowork.entity.UserBean;
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
public class CheckNameController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @GetMapping("/jdbc")
   // @ResponseBody
  /* @RequestMapping("/RegisterUser")
    public String show(){
        return "RegisterUser";
    }*/
    public void RegisterUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//获取ajax发送过来的name值
        String ReUsername=request.getParameter("ReUsername");
        System.out.println("xianxian6++++"+ReUsername);
        String sql="select Username from videousers where Username=?";
        String userresult=null;
        try {
            //检验是否存在该用户名
            userresult = jdbcTemplate.queryForObject(sql, java.lang.String.class, ReUsername);
        }
        catch (EmptyResultDataAccessException e)
        {
            userresult=null;
        }
            //通知页面，到底有没有
            if(userresult ==null || userresult==""){
                response.getWriter().println(2);//不存在用户名
            }else{
                response.getWriter().println(1);//存在该用户
                System.out.println("xian7++++"+userresult);
            }

    }
}
