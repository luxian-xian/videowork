package com.yanjiuyuan.videowork.serviceImpl;
import com.yanjiuyuan.videowork.dao.InsertNameMapper;
import com.yanjiuyuan.videowork.service.InserNameService;
import com.yanjiuyuan.videowork.entity.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("InserNameService")
public class InserNameimpl implements InserNameService{
    @Autowired
    private InsertNameMapper insernamemapper;
    @Override
    public UserBean Insertuser(String Username,String Userpwd)
    {
        return insernamemapper.insertInfo(Username,Userpwd);
    }
}
