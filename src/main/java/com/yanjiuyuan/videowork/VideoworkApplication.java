package com.yanjiuyuan.videowork;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yanjiuyuan.videowork.dao")
public class VideoworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoworkApplication.class, args);
    }

}
