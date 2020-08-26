package com.athjt.service;

import com.athjt.entity.Classroom;

import java.util.List;

public interface ClassroomService  extends IService<Classroom>{
	List<Classroom> getClassroomListByCourseId(Integer courseId);
	Classroom getClassroomById(Classroom classroom);
}