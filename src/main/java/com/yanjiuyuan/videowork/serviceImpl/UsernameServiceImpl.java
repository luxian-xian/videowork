package com.yanjiuyuan.videowork.serviceImpl;
import com.yanjiuyuan.videowork.dao.UsernameMapper;
import com.yanjiuyuan.videowork.service.UsernameService;
import com.yanjiuyuan.videowork.entity.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UsernameService")
public class UsernameServiceImpl implements UsernameService{
    @Autowired
    private UsernameMapper usermapper;
    @Override
   public UserBean loginName(String Username){
        return usermapper.getName(Username);
    }
}
