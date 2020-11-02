package com.yanjiuyuan.videowork.serviceImpl;
import com.yanjiuyuan.videowork.dao.videoinfoMapper;
import  com.yanjiuyuan.videowork.entity.VideoBean;
import com.yanjiuyuan.videowork.service.videoinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("videoinfoService")
public class videoinfoServiceimpl implements videoinfoService {
    @Autowired
    private videoinfoMapper videoinfomapper;
    @Override
    public List<VideoBean> getvideolist() {return videoinfomapper.getvideinfo();}
}
