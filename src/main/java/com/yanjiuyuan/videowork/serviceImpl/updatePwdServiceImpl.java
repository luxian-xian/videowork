package com.yanjiuyuan.videowork.serviceImpl;
import com.yanjiuyuan.videowork.dao.UpdatePwdMapper;
import com.yanjiuyuan.videowork.service.updatePwdService;
import com.yanjiuyuan.videowork.entity.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("updatePwdService")
public class updatePwdServiceImpl implements updatePwdService{
    @Autowired
    private UpdatePwdMapper updatepwdmapper;
    @Override
    public UserBean UpdatePwd(String Username,String Userpwd)
    {
        return updatepwdmapper.updateInfo(Username,Userpwd);
    }
}
