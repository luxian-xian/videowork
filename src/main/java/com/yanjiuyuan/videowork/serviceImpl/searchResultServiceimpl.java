package com.yanjiuyuan.videowork.serviceImpl;
import com.yanjiuyuan.videowork.dao.searchResultMapper;
import com.yanjiuyuan.videowork.service.searchResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service("searchResultService")
public class searchResultServiceimpl implements searchResultService {
    @Autowired
    private searchResultMapper searchresultmapper;
    @Override
    public List<String>getsearchresultservice( String videoname)
    {
        return searchresultmapper.getsearchlist( videoname);

    }
}
