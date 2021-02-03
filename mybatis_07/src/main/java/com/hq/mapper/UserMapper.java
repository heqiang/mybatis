package com.hq.mapper;

import com.hq.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    User queryUserById(@Param("Uid") int id);

    int updateUser(User user);
}
