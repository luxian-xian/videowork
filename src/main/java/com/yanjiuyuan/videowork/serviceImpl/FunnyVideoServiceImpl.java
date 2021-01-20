package com.yanjiuyuan.videowork.serviceImpl;
import com.yanjiuyuan.videowork.dao.FunnyVideoMapper;
import com.yanjiuyuan.videowork.service.FunnyVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service("FunnyVideoService")
public class FunnyVideoServiceImpl implements  FunnyVideoService{
    @Autowired
    private FunnyVideoMapper funnyvideomapper;
    @Override
    public List<String>getfunnyvideoservice(String videotype)
    {
        return funnyvideomapper.getfunnyvideolist(videotype);

    }
}
