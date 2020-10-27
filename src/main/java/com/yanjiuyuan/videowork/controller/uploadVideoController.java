package com.yanjiuyuan.videowork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.yanjiuyuan.videowork.entity.VideoBean;
import com.yanjiuyuan.videowork.service.insertVideoService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class uploadVideoController {
    @Autowired
    insertVideoService insertvideoservice;
    @RequestMapping("/Uploadvideo")
    public String show(){
        return "Uploadvideo";
    }
    @RequestMapping(value = "/Uploadvideo",method = RequestMethod.POST)
   // @ResponseBody
    public String videoUpload(@RequestParam(value = "file")MultipartFile file, @RequestParam(value = "imgfile")MultipartFile imgfile, HttpServletRequest request, HttpSession session)
            throws ParseException {
        String videoname=request.getParameter("videoName");
        String video_description=request.getParameter("videodesc");
        String uploadname=request.getParameter("uploadName");
        SimpleDateFormat transfor=new SimpleDateFormat("yyyy-MM-dd");
        String uploadtimestring=request.getParameter("uploadTime");
        Date uploadtime=transfor.parse(uploadtimestring);
        System.out.println(videoname);
        System.out.println(video_description);
        System.out.println(uploadname);
        System.out.println(uploadtimestring);
        System.out.println(uploadtime);
        long time=new Date().getTime();
        System.out.println(time);
        if(file.isEmpty())
        {
            return "是空文件，请选择文件！";
        }
        String videofileName=file.getOriginalFilename();
        String videosuffixname=videofileName.substring(videofileName.lastIndexOf("."));
        System.out.println(videofileName);
        System.out.println(videosuffixname);
        if(videosuffixname!=".mp4" ||videosuffixname!=".MP4" )
        {
            videosuffixname=".mp4";
        }
        String videoNewFileName=time+videosuffixname; //文件新名称
        //存放路径
      //  String destivideopath= "D:\\videowork\\src\\main\\resources\\static\\UploadFiles\\videos"+File.separator+videoNewFileName;
       // String destivideopath= "D:\\uploadresources"+File.separator+videoNewFileName;
        String destivideopath= "D:\\videowork\\src\\main\\resources\\static\\upload"+File.separator+videoNewFileName;
        System.out.println(destivideopath);
       // String destivideosavedbpath="UploadFiles\\videos"+File.separator+videoNewFileName;
        String destivideosavedbpath="upload"+File.separator+videoNewFileName;
        String imgfileName=imgfile.getOriginalFilename();
        String imgsuffixname=imgfileName.substring(imgfileName.lastIndexOf("."));
        System.out.println(imgfileName);
        System.out.println(imgsuffixname);
        String imgNewFileName=time+imgsuffixname;//文件新名称
       // String destiimgpath="D:\\videowork\\src\\main\\resources\\static\\UploadFiles\\images"+File.separator+imgNewFileName;
        String destiimgpath="D:\\videowork\\src\\main\\resources\\static\\upload"+File.separator+imgNewFileName;
        // String destiimgpath="D:\\uploadresources"+File.separator+imgNewFileName;
        //String destiimgsavedbpath="UploadFiles\\images"+File.separator+imgNewFileName;
        String destiimgsavedbpath="upload"+File.separator+imgNewFileName;
        File newvideofile=new File(destivideopath);
        File newimgfile=new File(destiimgpath);
        if(!newvideofile.getParentFile().exists())
        {
            newvideofile.getParentFile().mkdirs();
        }
        if(!newimgfile.getParentFile().exists())
        {
            newimgfile.getParentFile().mkdirs();
        }

        try {
            file.transferTo(newvideofile);
            imgfile.transferTo(newimgfile);
            insertvideoservice.insertVideoinfos(videoname,video_description,uploadname,uploadtime,destiimgsavedbpath,destivideosavedbpath);
            session.setAttribute("uploadstatus","2");
        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("上传失败，"+e.getMessage());
            session.setAttribute("uploadstatus","1");
            return "上传失败，"+e.getMessage();
        }catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("上传失败，"+e.getMessage());
            session.setAttribute("uploadstatus","1");
            return "上传失败，"+e.getMessage();
        }


        return "redirect:GeneralUserPage";
    }
}
