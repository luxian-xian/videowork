package com.yanjiuyuan.videowork.controller;
import com.yanjiuyuan.videowork.entity.VideoBean;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yanjiuyuan.videowork.service.videoinfoService;

import java.util.List;


@Controller
public class AdmindisplayController {
    @Autowired
    videoinfoService videoinfoservice;
    @RequestMapping("/AdminPage")
    public String show(){
        return "AdminPage";
    }

    @ResponseBody
    @RequestMapping(value="/videolist")
    public  Object getvideolist()
    {

        System.out.println("xian+++video");
        List<VideoBean> videobean = (List<VideoBean>) videoinfoservice.getvideolist();
        System.out.println(videobean.size());
         for (int i = 0; i < videobean.size(); i++) {
            System.out.println(videobean.get(i).getUploadtime());
             System.out.println(videobean.get(i).getImg_path());
             System.out.println(videobean.get(i).getVideoname());
             System.out.println(videobean.get(i).getVideo_path());


         }

        JSONArray data=JSONArray.fromObject(videobean);
        return data;
    }


}
