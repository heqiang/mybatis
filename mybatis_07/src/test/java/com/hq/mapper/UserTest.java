package com.hq.mapper;

import com.hq.pojo.User;
import com.hq.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserTest {
    /*
     * 在打开sqlsession 和关闭sqlsession之间的会被缓存起来
     * 以及缓存是默认开启的，只在一次SqlSession中有效，也就是打开这个连接和关闭这个连接的区间
     * 一次缓存相当于一个map
     * 缓存失效的情况：
     *           1、所有的增 删 改操作可能会改变原来的数据 所以必定会刷新缓存
     *           2、查询不同的东西
     *           3、查询不同的mapper
     *           4、手动清理缓存 sqlSession.clearCache()
     * */
    @Test
    public void queryUserById() {
        // 在一个session中查询两次相同的记录查询只会走一次
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
        System.out.println("================");
        sqlSession.close();

        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 = mapper1.queryUserById(1);
        System.out.println(user1);
        System.out.println(user == user1);
        sqlSession1.close();
    }

    @Test
    public void queryUserById1() {
        // 在一个session中查询两次相同的记录查询只会走一次
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
        System.out.println("================");
        User user1 = mapper.queryUserById(1);
        System.out.println(user1);
        System.out.println(user == user1);
        sqlSession.close();


    }
}
