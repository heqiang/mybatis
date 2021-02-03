package com.hq.mapper;

import com.hq.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    //获取所有的老师
    List<Teacher> getAllTeacher();

    //获取指定老师下的学生及学生信息
    List<Teacher> getAllTeacher_stu(@Param("t_id") int id);
}
