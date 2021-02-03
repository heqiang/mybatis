package com.hq.mapper;

import com.hq.pojo.Student;

import java.util.List;

public interface StudentMapper {
    //  获取学生的老师 多对一
    List<Student> getStudentTeacher();
}
