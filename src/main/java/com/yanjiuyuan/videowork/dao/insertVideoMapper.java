package com.yanjiuyuan.videowork.dao;
import com.yanjiuyuan.videowork.entity.UserBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.yanjiuyuan.videowork.entity.VideoBean;

import java.util.Date;

@Repository
@Component
public interface insertVideoMapper {
    VideoBean insertVideoInfo(String videoname, String video_description, String video_type,String uploadname, Date uploadtime, String img_path,String video_path);
}
