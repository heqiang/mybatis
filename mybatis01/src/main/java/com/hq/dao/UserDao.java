package com.hq.dao;

import com.hq.pojo.User;

import java.util.List;

public interface UserDao {
//    获取全部用户
     List<User> getUserList();
     //根据id查询用户
     User  getUserById(int id);
     //增加一个用户
     int  insertUser(User user);
     // 更新用户
     int updateUser(User user);

     //删除用户
     int deleteUser(int id);
}
