package com.yanjiuyuan.videowork.controller;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.yanjiuyuan.videowork.service.LearnVideoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
@Controller
public class LearnVideoController {
    @Autowired
    LearnVideoService learnvideoservice;
    @RequestMapping(value="/learnvideo")
    public String getlearnvideo() {
        return "learnvideo";
    }
    @ResponseBody
    @RequestMapping(value="/learnPath")
    public Object getpathdb11(){
        String video_type="学习视频";
        List<String> pathList = learnvideoservice.getlearnvideoservice(video_type);
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
