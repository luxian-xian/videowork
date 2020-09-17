package com.yanjiuyuan.videowork;

//import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.yanjiuyuan.videowork.entity.UserBean;
import com.yanjiuyuan.videowork.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class VideoworkApplicationTests {
    @Autowired
    UserService userservice;

    @Test
   public void contextLoads() {
        UserBean userbean=userservice.loginIn("Admin","123456");
        System.out.println("该用户ID为：");
        System.out.println(userbean.getId());
    }

}
