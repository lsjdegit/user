package com.zt.entity;

/**
 * @author scj
 * @create 2020-04-15 15:32
 */
public class Users {
   private int userid;
   private String username;
   private String userpassword;
   private String useremail;
   private int userversion;
   private int userststus;

    public Users() {
    }

    public Users(int userid, String username, String userpassword, String useremail, int userversion, int userststus) {
        this.userid = userid;
        this.username = username;
        this.userpassword = userpassword;
        this.useremail = useremail;
        this.userversion = userversion;
        this.userststus = userststus;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public int getUserversion() {
        return userversion;
    }

    public void setUserversion(int userversion) {
        this.userversion = userversion;
    }

    public int getUserststus() {
        return userststus;
    }

    public void setUserststus(int userststus) {
        this.userststus = userststus;
    }
}
