package com.yanjiuyuan.videowork.controller;



import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.yanjiuyuan.videowork.service.GetPathService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
@Controller
public class GetPathController {
    @Autowired
    GetPathService getpathservice;
    @RequestMapping(value="/GeneralUserPage")
    public String getpathdb() {
        return "GeneralUserPage";
    }

    @ResponseBody
    @RequestMapping(value="/picPath")
    public Object getpathdb11(){
        List<String> pathList = getpathservice.getpathservice();
        System.out.println(pathList.size());
        /*String imgpath = "";
        String videopath = "";*/
        /*for (int i = 0; i < mapList.size(); i++) {
            Map<String, String> map = mapList.get(i);
            System.out.println(map.get("img_path"));
            System.out.println(map.get("video_path"));
        }*/
        for (int i = 0; i < pathList.size(); i++) {
            System.out.println(pathList.get(i));

        }
       /* try
        {*/ System.out.println("xian11");
            JSONArray data=JSONArray.fromObject(pathList);
            System.out.println(data);
            return data;

       /* }catch (Exception e){
            e.printStackTrace();
        }*/
    }
}
