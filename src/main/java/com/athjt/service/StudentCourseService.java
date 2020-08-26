package com.athjt.service;


import com.athjt.entity.Student;
import com.athjt.entity.StudentCourse;

import java.util.List;

public interface StudentCourseService extends IService<StudentCourse>{
    
    List<StudentCourse> queryStudentCourseList();
    
    int saveStudentCourse(StudentCourse studentCourse);
    int updateStudentCourse(StudentCourse studentCourse);
    
    int queryCourseBystuIdAndCourseIdAndRoomId(Integer studentId,Integer courseId,Integer classroomId);
    
    
    List<StudentCourse> queryStudentCourseListByStudentId(Integer studentId);
}