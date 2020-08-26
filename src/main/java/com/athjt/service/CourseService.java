package com.athjt.service;

import com.athjt.entity.Course;

import java.util.List;

public interface CourseService  extends IService<Course>{

	List<Course> getCourseList();
	
	Course getCourseById(Course classroom);
}