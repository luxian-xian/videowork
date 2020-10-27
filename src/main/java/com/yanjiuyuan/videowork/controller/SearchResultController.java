package com.yanjiuyuan.videowork.controller;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.yanjiuyuan.videowork.service.searchResultService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
@Controller
public class SearchResultController {
    @Autowired
    searchResultService searchresultservice;
    @RequestMapping(value = "/SearchVideo")
    public String getresultlist()
    {
        return "SearchVideo";
    }
    @ResponseBody
    @RequestMapping(value = "/resultList")
    public Object getvideolist(){
        List<String> pathList = searchresultservice.getsearchresultservice();
        System.out.println(pathList.size());
        for (int i = 0; i < pathList.size(); i++) {
            System.out.println(pathList.get(i));

        }
        JSONArray data=JSONArray.fromObject(pathList);
        System.out.println(data);
        return data;
    }
}
