package com.hq.dao;

import com.hq.pojo.User;
import com.hq.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserDaoTest {
    static Logger logger = Logger.getLogger(UserDaoTest.class);
    @Test
    public void test(){
        //获取sqlsession对象
        SqlSession  sqlSession = MybatisUtils.getSqlSession();
        //方式一 执行
        try {
            UserDao userDao = sqlSession.getMapper(UserDao.class);

            List<User> userList = userDao.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        }catch (Exception e){
            System.out.println(e);
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
            int res = userDao.insertUser(new User(6,"hqq",11));
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

    @Test
    public   void  addUser(){
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            try {
                UserDao  userDao = sqlSession.getMapper(UserDao.class);
                Map<String,Object> map  = new HashMap<String,Object>();
                map.put("id",2);
                map.put("name","map");
                map.put("password",123);
                int  res = userDao.addUser(map);
                if (res==1){
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
    public   void  getUserByLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UserDao userDao=sqlSession.getMapper(UserDao.class);
            List<User>  userlist = userDao.getUserListByLike("%h%");
            for (User user : userlist) {
                System.out.println(user.getName());
            }
            sqlSession.commit();

        }catch (Exception e){
            System.out.println(e);
        }finally {
            sqlSession.close();
        }
    }
    @Test
    public  void  log4jprint(){
        logger.info("info:进入了test");
    }
    @Test
    public  void getUserBylimit(){
        SqlSession  sqlSession = MybatisUtils.getSqlSession();
        UserDao  userDao = sqlSession.getMapper(UserDao.class);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("startIndex",3);
        map.put("pageSize",10);
        List<User>  userlist = userDao.getUserBylimit(map);
        for (User user : userlist) {
            System.out.println(user);
        }
    }

}

