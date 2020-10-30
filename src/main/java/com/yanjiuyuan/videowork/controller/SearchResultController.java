package com.yanjiuyuan.videowork.controller;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.yanjiuyuan.videowork.service.searchResultService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
@Controller
//@RequestMapping(value = "/SearchVideo")
public class SearchResultController {
    @Autowired
    searchResultService searchresultservice;
    @RequestMapping(value = "/SearchVideo")
    public String getresultlist()
    {
        return "SearchVideo";
    }

  @RequestMapping(value = "/data"/*,method = RequestMethod.POST*/)
  @ResponseBody
    public /*Object*/  Object getvideolist(@RequestParam("Searchname") String Searchname) throws UnsupportedEncodingException {
        //String serchname=request.getParameter("Searchname");
      String serchname= URLDecoder.decode(Searchname,"UTF-8");;
        System.out.println("xianxian6++++"+serchname);

      System.out.println("xianxian7++++"+Searchname);
      List<String> pathList = searchresultservice.getsearchresultservice(serchname);
        System.out.println(pathList.size());
        for (int i = 0; i < pathList.size(); i++) {
            System.out.println(pathList.get(i));

        }
        JSONArray data=JSONArray.fromObject(pathList);
       System.out.println(data);
        //return "SearchVideo";
        return data;
    }
}
