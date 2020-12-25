package com.hq.dao;

import com.hq.pojo.User;
import com.hq.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void test(){
        //获取sqlsession对象
        SqlSession  sqlSession = MybatisUtils.getSqlSession();
        //方式一 执行
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();
        for (User user : userList) {
            System.out.println(user.getName());
        }
        sqlSession.close();

    }
}

