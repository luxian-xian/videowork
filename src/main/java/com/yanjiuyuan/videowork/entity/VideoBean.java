package com.yanjiuyuan.videowork.entity;

import java.util.Date;

public class VideoBean {
    private int id;
    private String videoname;
    private String uploadname;
    private Date uploadtime;
    private String img_path;
    private String video_description;
    private String video_path;
    public int getId()
    {
        return  id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getVideoname()
    {
        return videoname;
    }
    public  void  setVideoname(String videoname)
    {
        this.videoname = videoname;
    }
    public  String getUploadname()
    {
        return uploadname;
    }
    public  void setUploadname(String uploadname)
    {
        this.uploadname = uploadname;
    }
    public  Date getUploadtime()
    {
        return uploadtime;
    }
    public  void setUploadtime(Date uploadtime)
    {
        this.uploadtime = uploadtime;
    }
    public  String getImg_path()
    {
        return img_path;
    }
    public  void  setImg_path(String img_path)
    {
        this.img_path = img_path;
    }
    public  String getVideo_description()
    {
        return video_description;
    }
    public  void  setVideo_description(String video_description)
    {
        this.video_description = video_description;
    }
    public  String getVideo_path()
    {
        return video_path;
    }
    public  void  setVideo_path(String video_path)
    {
        this.video_path = video_path;
    }
}
