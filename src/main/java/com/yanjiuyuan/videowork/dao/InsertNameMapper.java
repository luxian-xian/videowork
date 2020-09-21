package com.yanjiuyuan.videowork.dao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.yanjiuyuan.videowork.entity.UserBean;
@Repository
@Component
public interface InsertNameMapper {
    UserBean insertInfo(String Username,String Userpwd);
}
