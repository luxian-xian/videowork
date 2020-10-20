package com.yanjiuyuan.videowork.serviceImpl;
import com.yanjiuyuan.videowork.dao.GetPathMapper;
import com.yanjiuyuan.videowork.service.GetPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
@Service("GetPathService")
public class GetPathServiceimpl implements GetPathService{
    @Autowired
    private GetPathMapper getpathmapper;
    @Override
    public List<Map<String,String>>getpathservice()
    {
        return getpathmapper.getpath();

    }
}
