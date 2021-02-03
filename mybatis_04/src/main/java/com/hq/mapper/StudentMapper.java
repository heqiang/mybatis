package com.hq.mapper;

import com.hq.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> getStudentList();

    //   联表查询
    List<Student> getStudentTeacher();
}
