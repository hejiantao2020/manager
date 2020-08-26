package com.athjt.service.impl;

import com.athjt.entity.Student;
import com.athjt.entity.StudentCourse;
import com.athjt.mapper.StudentCourseMapper;
import com.athjt.mapper.StudentMapper;
import com.athjt.service.StudentCourseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNameStudentCourseServiceImpl
 * @Description
 * @Author hejiantao
 * @Date2020/8/24 16:53
 * @Version V1.0
 **/
@Service("studentCourseService")
public class StudentCourseServiceImpl extends  BaseService<StudentCourse> implements StudentCourseService {
	
	@Autowired
	private StudentCourseMapper studentCourseMapper;
	
	@Override
	public List<StudentCourse> queryStudentCourseList() {
		List<StudentCourse> studentCourses = studentCourseMapper.selectStudentCourseList();
		return studentCourses;
	}
	
	@Override
	public int saveStudentCourse(StudentCourse studentCourse) {
		return studentCourseMapper.insertSelective(studentCourse);
	}
	
	@Override
	public int updateStudentCourse(StudentCourse studentCourse) {
		return studentCourseMapper.updateById(studentCourse);
	}
	
	@Override
	public int queryCourseBystuIdAndCourseIdAndRoomId(@Param("studentId") Integer studentId, @Param("courseId") Integer courseId, @Param("classroomId") Integer classroomId) {
//		QueryWrapper<StudentCourse> queryWrapper = new QueryWrapper<>();
//		queryWrapper.eq("student_id",studentId);
//		queryWrapper.eq("course_id",courseId);
//		queryWrapper.eq("classroom_id",classroomId);
		//studentCourseMapper.selectCount(queryWrapper);
		StudentCourse studentCourse = new StudentCourse();
		studentCourse.setStudentId(studentId);
		studentCourse.setCourseId(courseId);
		studentCourse.setClassroomId(classroomId);
		
		return studentCourseMapper.selectCount(studentCourse);
	}
	
	@Override
	public List<StudentCourse> queryStudentCourseListByStudentId(Integer studentId) {
		QueryWrapper<StudentCourse> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("student_id",studentId);
		return studentCourseMapper.selectList(queryWrapper);
	}
}
