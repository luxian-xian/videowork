package com.yanjiuyuan.videowork.controller;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.yanjiuyuan.videowork.service.searchResultService;
import com.yanjiuyuan.videowork.service.getsplitimgService;
import com.yanjiuyuan.videowork.service.getsplitvideoService;
import com.yanjiuyuan.videowork.service.getsplitnameService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
@Controller
//@RequestMapping(value = "/SearchVideo")
public class SearchResultController {
    @Autowired
    searchResultService searchresultservice;
    @Autowired
    getsplitimgService getsplitimgservice;
    @Autowired
    getsplitvideoService getsplitvideoservice;
    @Autowired
    getsplitnameService getsplitnameservice;
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
      List<String> pathList=new ArrayList<String>();
       if(serchname.contains(",")||serchname.contains(";")||serchname.contains("，")||serchname.contains("；"))
       {

            serchname= serchname.replace("，",",");
           serchname= serchname.replace("；",",");
           serchname= serchname.replace(";",",");
           System.out.println("替换后"+serchname);
           String[] splits= serchname.split(",");
           List<String> imgpathlist=new ArrayList<String>();
           List<String> videopathlist=new ArrayList<String>();
           List<String> namelist=new ArrayList<String>();
           for (int i =0;i<splits.length;i++)
           { System.out.println("分割数量"+i+splits.length);
               System.out.println("多关键字搜索"+i+splits[i]);
               imgpathlist.addAll(getsplitimgservice.getsearchimgservice(splits[i]));
               videopathlist.addAll(getsplitvideoservice.getsearchvideoservice(splits[i]));
               namelist.addAll(getsplitnameservice.getsearchnameservice(splits[i]));
               System.out.println(imgpathlist.size());
               System.out.println(videopathlist.size());
               System.out.println(namelist.size());

           }
          //去重
           List<String> distinctimgpathlist=new ArrayList<String>();
           List<String> distinctvideopathlist=new ArrayList<String>();
           List<String> distinctnamelist=new ArrayList<String>();
           for(String s:imgpathlist)
           {
               if(!distinctimgpathlist.contains(s))
               {
                   distinctimgpathlist.add(s);
               }
           }
           for(String ss:videopathlist)
           {
               if(!distinctvideopathlist.contains(ss))
               {
                   distinctvideopathlist.add(ss);
               }
           }
           for(String sss:namelist)
           {
               if(!distinctnamelist.contains(sss))
               {
                   distinctnamelist.add(sss);
               }
           }
           System.out.println("去重后img" + distinctimgpathlist);
           System.out.println("去重后video" + distinctvideopathlist);
           System.out.println("去重后img" + distinctnamelist);

           pathList.addAll(distinctimgpathlist);
           pathList.addAll(distinctvideopathlist);
           pathList.addAll(distinctnamelist);
           System.out.println("最终list" + pathList);

       }
     else {
          pathList = searchresultservice.getsearchresultservice(serchname);
           System.out.println(pathList.size());
           for (int i = 0; i < pathList.size(); i++) {
               System.out.println(pathList.get(i));

           }
       }
        JSONArray data=JSONArray.fromObject(pathList);
       System.out.println(data);
        //return "SearchVideo";
        return data;
    }
}
