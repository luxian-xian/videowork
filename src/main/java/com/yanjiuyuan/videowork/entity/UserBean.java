package com.yanjiuyuan.videowork.entity;

public class UserBean {
    private int id;
    private String Username;
    private String Userpwd;
    private  String UserAuthority;
    public int getId()
    {
        return  id;
    }
    public void setid(int id)
    {
        this.id = id;
    }
    public String getUsername()
    {
        return Username;
    }
    public  void  setUsername(String Username)
    {
        this.Username = Username;
    }
    public  String getUserpwd()
    {
        return Userpwd;
    }
    public  void setUserpwd(String Userpwd)
    {
        this.Userpwd = Userpwd;
    }
    public  String getUserAuthority()
    {
        return UserAuthority;
    }
    public  void  setUserAuthority(String UserAuthority)
    {
        this.UserAuthority = UserAuthority;
    }

}
