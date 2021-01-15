package com.yanjiuyuan.videowork.serviceImpl;
import com.yanjiuyuan.videowork.dao.SceneryVideoMapper;
import com.yanjiuyuan.videowork.service.SceneryVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service("SceneryVideoService")
public class SceneryVideoServiceImpl implements SceneryVideoService {
    @Autowired
    private SceneryVideoMapper sceneryvideomapper;
    @Override
    public List<String>getsceneryvideoservice(String videotype)
    {
        return sceneryvideomapper.getsceneryvideolist(videotype);

    }
}
