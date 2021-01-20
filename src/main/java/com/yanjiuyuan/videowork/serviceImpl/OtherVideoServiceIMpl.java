package com.yanjiuyuan.videowork.serviceImpl;
import com.yanjiuyuan.videowork.dao.OtherVideoMapper;
import com.yanjiuyuan.videowork.service.OtherVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service("OtherVideoService")
public class OtherVideoServiceIMpl implements OtherVideoService {
    @Autowired
    private  OtherVideoMapper othervideomapper;
    @Override
    public List<String>getlearnotherservice(String videotype)
    {
        return othervideomapper.getothervideolist(videotype);

    }
}
