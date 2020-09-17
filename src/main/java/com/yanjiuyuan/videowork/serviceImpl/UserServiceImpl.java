package com.yanjiuyuan.videowork.serviceImpl;
import com.yanjiuyuan.videowork.entity.UserBean;
import com.yanjiuyuan.videowork.dao.UserMapper;
import com.yanjiuyuan.videowork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("UserService")
public class UserServiceImpl implements UserService{
    @Autowired(required = false)
    private UserMapper usermapper;
    @Override
    public UserBean loginIn(String Username,String Userpwd)
    {
        return usermapper.getInfo(Username,Userpwd);
    }
}
