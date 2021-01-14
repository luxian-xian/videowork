package com.yanjiuyuan.videowork.serviceImpl;
import com.yanjiuyuan.videowork.dao.videosplitMapper;
import com.yanjiuyuan.videowork.service.getsplitvideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service("getsplitvideoService")
public class getsplitvideoserImpl implements getsplitvideoService {
    @Autowired
    private videosplitMapper videosplitmapper;
    @Override
    public List<String>getsearchvideoservice( String videoname)
    {
        return videosplitmapper.getsearchvideolist( videoname);

    }
}
