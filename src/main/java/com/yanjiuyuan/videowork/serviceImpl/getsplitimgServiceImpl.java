package com.yanjiuyuan.videowork.serviceImpl;
import com.yanjiuyuan.videowork.dao.GetSplitimgpathMapper;
import com.yanjiuyuan.videowork.service.getsplitimgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service("getsplitimgService")
public class getsplitimgServiceImpl implements getsplitimgService {
    @Autowired
    private GetSplitimgpathMapper getsplitimgpathmapper;
    @Override
    public List<String>getsearchimgservice( String videoname)
    {
        return getsplitimgpathmapper.getsearchimglist( videoname);

    }
}
