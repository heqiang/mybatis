package com.hq.mapper;


import com.hq.pojo.Student;
import com.hq.pojo.Teacher;
import com.hq.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentTest {
    @Test
    public void  getAllTeacher(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> allTeacher = studentMapper.getStudentTeacher();
            for (Student stu : allTeacher) {
                System.out.println(stu.getTeacher().getName());
            }
        }catch (Exception e){
            System.out.println(e);
        }finally {
            sqlSession.close();
        }
    }
}
