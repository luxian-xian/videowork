package com.yanjiuyuan.videowork.serviceImpl;
import com.yanjiuyuan.videowork.dao.LearnVideoMapper;
import com.yanjiuyuan.videowork.service.LearnVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service("LearnVideoService")
public class LearnVideoServiceImpl implements LearnVideoService{
    @Autowired
    private  LearnVideoMapper learnvideomaper;
    @Override
    public List<String>getlearnvideoservice(String videotype)
    {
        return learnvideomaper.getlearnvideolist(videotype);

    }
}
