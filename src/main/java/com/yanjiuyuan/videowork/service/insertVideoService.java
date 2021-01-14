package com.yanjiuyuan.videowork.service;
import com.yanjiuyuan.videowork.entity.VideoBean;

import java.util.Date;

public interface insertVideoService {
    VideoBean insertVideoinfos(String videoname, String video_description, String video_type,String uploadname, Date uploadtime,String img_path,String video_path);
}
