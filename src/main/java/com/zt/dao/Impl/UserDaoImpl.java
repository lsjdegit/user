package com.zt.dao.Impl;

import com.zt.entity.Users;
import com.zt.mapper.UserMapper;
import com.zt.util.BaseUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author scj
 * @create 2020-04-15 15:47
 */
public class UserDaoImpl implements UserMapper {
    @Override
    public Users login(Users us) {
        String sql="select * from user where username=? and userpassword=? ";
        ResultSet rs=BaseUtil.executeQuery(sql,us.getUsername(),us.getUserpassword());
        Users use=null;
        try {
            if(rs.next()){
                use=new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return use;
    }

    @Override
    public int deluser(int userid) {
        String sql="delete from user where userid=?";
       int a= BaseUtil.executeUpdate(sql,userid);
        return a;
    }

    @Override
    public int updateuser(Users user) {
        String sql="update user set useremail=? where userid=?";
      int a=  BaseUtil.executeUpdate(sql,user.getUseremail(),user.getUserid());
      return a;
    }

    @Override
    public int adduser(Users user) {
        String sql="insert into user(username,userpassword,useremail,userversion,userststus) values(?,?,?,?,?)";
        int a=  BaseUtil.executeUpdate(sql,user.getUsername(),user.getUserpassword(),user.getUseremail(),user.getUserversion(),user.getUserststus());
        return a;
    }

    @Override
    public List<Users> selectAll() {
       String sql="select * from user";
        ResultSet rs=BaseUtil.executeQuery(sql);
        List<Users> ulist=new ArrayList<Users>();;
        try {
            while(rs.next()){
     Users us=new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));
                ulist.add(us);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return ulist;
    }
}
