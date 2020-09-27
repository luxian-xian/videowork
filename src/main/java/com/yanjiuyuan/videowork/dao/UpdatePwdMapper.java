package com.yanjiuyuan.videowork.dao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.yanjiuyuan.videowork.entity.UserBean;
@Repository
@Component
public interface UpdatePwdMapper {
    UserBean updateInfo(String Username,String Userpwd);
}
