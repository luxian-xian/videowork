package com.yanjiuyuan.videowork.dao;
import com.yanjiuyuan.videowork.entity.VideoBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface videoinfoMapper {
    List<VideoBean> getvideinfo();
    VideoBean getsearchvideinfo(String videoname);
}
