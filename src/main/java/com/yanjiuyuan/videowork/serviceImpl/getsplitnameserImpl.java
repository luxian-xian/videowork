package com.yanjiuyuan.videowork.serviceImpl;
import com.yanjiuyuan.videowork.dao.GetsplitnameMapper;
import com.yanjiuyuan.videowork.service.getsplitnameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service("getsplitnameService")
public class getsplitnameserImpl implements getsplitnameService{
    @Autowired
    private GetsplitnameMapper getsplitnamemapper;
    @Override
    public List<String>getsearchnameservice( String videoname)
    {
        return getsplitnamemapper.getsearchnamelist( videoname);

    }
}
