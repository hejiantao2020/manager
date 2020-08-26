package com.athjt.service.impl;

import com.athjt.entity.Course;
import com.athjt.mapper.CourseMapper;
import com.athjt.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassNameCourseServiceImpl
 * @Description
 * @Author hejiantao
 * @Date2020/8/21 20:20
 * @Version V1.0
 **/
@Service("courseService")
public class CourseServiceImpl  extends  BaseService<Course> implements CourseService {
	@Resource
	private CourseMapper courseMapper;
	@Override
	public List<Course> getCourseList() {
		return courseMapper.selectAll();
	}
	
	@Override
	public Course getCourseById(Course course) {
		return courseMapper.selectOne(course);
	}
}
