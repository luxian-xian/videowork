package com.yanjiuyuan.videowork.configure;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class uploadconfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //获取文件的真实路径
        //String path = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\images\\";
     // String path="D:\\videowork\\src\\main\\resources\\static\\UploadFiles";
        //       /images/**是对应resource下工程目录

       // registry.addResourceHandler("/upload/**").addResourceLocations("file:D:/videowork/src/main/resources/static/upload/");
        registry.addResourceHandler("/upload/**").addResourceLocations("file:E:/videowork_extension/src/main/resources/static/upload/");
      //  registry.addResourceHandler("/upload/**").addResourceLocations("file:/usr/ideaProject/file:/usr/ideaProject/src/main/resources/static/upload/");


    }
}
