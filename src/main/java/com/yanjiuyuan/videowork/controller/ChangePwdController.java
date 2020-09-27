package com.yanjiuyuan.videowork.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

import com.yanjiuyuan.videowork.entity.UserBean;
import com.yanjiuyuan.videowork.service.updatePwdService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ChangePwdController {
    @Autowired
    updatePwdService  updatepwdservice  ;

   /* @Autowired
    JdbcTemplate jdbcTemplate;
    @GetMapping("/jdbc")*/
   @RequestMapping("/Changepwd")
    public String show(){
        return "Changepwd";
    }
    @RequestMapping(value = "/Changepwd",method = RequestMethod.POST)
    public String Changepwd(HttpServletRequest request)  {
        String chUsername=request.getParameter("ChaUsername");
        //String chUsername= (String) request.getAttribute("ChaUsername");
        String chaconUserpwd=request.getParameter("chaconUserpwd");
        System.out.println("xianxian6++++"+chUsername);
        System.out.println("xianxian7++++"+chaconUserpwd);

        /*String sql="select Username from videousers where Username=?";
        String userresult=null;
        try {
            //检验是否存在该用户名
            userresult = jdbcTemplate.queryForObject(sql, java.lang.String.class, chUsername);
        }
        catch (EmptyResultDataAccessException e)
        {
            userresult=null;
        }*/
        updatepwdservice.UpdatePwd(chUsername,chaconUserpwd);
        return "loginchgpwd";


    }
}
