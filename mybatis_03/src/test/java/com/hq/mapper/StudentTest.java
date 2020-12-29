package com.hq.mapper;

import com.hq.pojo.Student;
import com.hq.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentTest {
    @Test
    public void  getStudentList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> studentList =  studentMapper.getStudentList();
            for (Student student : studentList) {
                System.out.println(student.getName());
            }
        }catch (Exception e){
            System.out.println(e);
        }finally {
            sqlSession.close();
        }
    }
    @Test
    public void  getStudentTeacher(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> studentList =  studentMapper.getStudentTeacher();
            for (Student student : studentList) {
                System.out.println(student.getTeacher().getName());
            }
        }catch (Exception e){
            System.out.println(e);
        }finally {
            sqlSession.close();
        }
    }
}
