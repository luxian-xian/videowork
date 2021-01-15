package com.yanjiuyuan.videowork.controller;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.yanjiuyuan.videowork.service.SceneryVideoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
@Controller
public class SceneryVideoController {
    @Autowired
    SceneryVideoService sceneryvideoservice;
    @RequestMapping(value="/sceneryvideo")
    public String getsceneryvideo() {
        return "sceneryvideo";
    }
    @ResponseBody
    @RequestMapping(value="/sceneryPath")
    public Object getpathdb11(){
        String video_type="风景视频";
        List<String> pathList = sceneryvideoservice.getsceneryvideoservice(video_type);
        System.out.println(pathList);

       /* try
        {*/// System.out.println("xian11");
        JSONArray data=JSONArray.fromObject(pathList);
        //System.out.println(data);
        return data;

       /* }catch (Exception e){
            e.printStackTrace();
        }*/
    }

}
