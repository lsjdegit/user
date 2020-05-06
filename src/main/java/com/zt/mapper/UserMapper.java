package com.zt.mapper;

import com.zt.entity.Users;

import java.util.List;
/**
 * @author scj
 * @create 2020-04-15 15:45
 */
public interface UserMapper {
    public Users login(Users us);
    public int deluser(int userid);
    public int updateuser(Users user);
    public int adduser(Users user);
    public List<Users> selectAll();
}
