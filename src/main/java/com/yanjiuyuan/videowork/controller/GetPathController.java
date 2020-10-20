package com.yanjiuyuan.videowork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.yanjiuyuan.videowork.service.GetPathService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;
@Controller
public class GetPathController {
    @Autowired
    GetPathService getpathservice;

    @RequestMapping(value="/GeneralUserPage",method = RequestMethod.GET)
    public List<Map<String, String>> getpathdb() {
        List<Map<String, String>> mapList = getpathservice.getpathservice();
        System.out.println(mapList.size());
        String imgpath = "";
        String videopath = "";
        for (int i = 0; i < mapList.size(); i++) {
            Map<String, String> map = mapList.get(i);
            System.out.println(map.get("img_path"));
            System.out.println(map.get("video_path"));
        }
        return mapList;


    }
}
