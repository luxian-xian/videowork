package com.yanjiuyuan.videowork.dao;
import com.yanjiuyuan.videowork.entity.UserBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface UserMapper {
    UserBean getInfo(String Username,String Userpwd);
}
