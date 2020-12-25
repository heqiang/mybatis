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
        try {
            UserDao userDao = sqlSession.getMapper(UserDao.class);

            List<User> userList = userDao.getUserList();
            for (User user : userList) {
                System.out.println(user.getName());
            }
        }catch (Exception e){

        }finally {
            sqlSession.close();
        }

    }

    @Test
    public void  getUserById(){
        SqlSession  sqlSession = MybatisUtils.getSqlSession();
        //方式一 执行
        try {
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            User user = userDao.getUserById(1);
            System.out.println(user.getName());
        }catch (Exception e){

        }finally {
            sqlSession.close();
        }
    }
//    增删改 需要提交事务
    @Test
    public void  insertUser(){
        SqlSession  sqlSession = MybatisUtils.getSqlSession();
        //方式一 执行
        try {
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            int res = userDao.insertUser(new User(3,"hqq",11));
            if (res ==1){
                System.out.println("插入成功");
            }else {
                System.out.println("插入失败");
            }
            sqlSession.commit();

        }catch (Exception e){
            System.out.println(e);
        }finally {
            sqlSession.close();
        }
    }
    @Test
    public void  updateUser(){
        SqlSession  sqlSession = MybatisUtils.getSqlSession();
        //方式一 执行
        try {
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            int res = userDao.updateUser(new User(1,"修改",1565456));
            if (res ==1){
                System.out.println("更新成功");
            }else {
                System.out.println("更新失败");
            }
            sqlSession.commit();

        }catch (Exception e){
            System.out.println(e);
        }finally {
            sqlSession.close();
        }
    }
    @Test
    public void  deleteUser(){
        SqlSession  sqlSession = MybatisUtils.getSqlSession();
        //方式一 执行
        try {
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            int res = userDao.deleteUser(3);
            if (res ==1){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
            sqlSession.commit();

        }catch (Exception e){
            System.out.println(e);
        }finally {
            sqlSession.close();
        }
    }

}

