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
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            List<Teacher> allTeacher = mapper.getAllTeacher();
            for (Teacher teacher : allTeacher) {
                System.out.println(teacher.getName());
            }
        }catch (Exception e){
            System.out.println(e);
        }finally {
            sqlSession.close();
        }
    }
    /*
    * 获取指定老师下的所有学生
    * */
    @Test
    public  void  getAllTeacher_stu(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> allTeacher_stu = mapper.getAllTeacher_stu(1);

        for (Teacher teacher : allTeacher_stu) {
            System.out.println("老师的姓名："+teacher.getName());
            List<Student> students = teacher.getStudents();
            for (Student student : students) {
                System.out.println("学生的姓名："+student.getName());
            }
        }

    }

}
