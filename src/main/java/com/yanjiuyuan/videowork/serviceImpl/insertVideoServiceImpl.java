package com.yanjiuyuan.videowork.serviceImpl;
import com.yanjiuyuan.videowork.dao.insertVideoMapper;
import com.yanjiuyuan.videowork.service.insertVideoService;
import com.yanjiuyuan.videowork.entity.VideoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("insertVideoService")
public class insertVideoServiceImpl implements insertVideoService{
    @Autowired
    private insertVideoMapper insertvideomapper;
    @Override
    public VideoBean insertVideoinfos(String videoname, String video_description, String video_type,String uploadname, Date uploadtime,String img_path,String video_path)
    {
        return insertvideomapper.insertVideoInfo(videoname,video_description,video_type,uploadname,uploadtime,img_path, video_path);
    }
}
