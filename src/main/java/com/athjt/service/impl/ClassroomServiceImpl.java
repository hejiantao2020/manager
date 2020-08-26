package com.athjt.service.impl;

import com.athjt.entity.Classroom;
import com.athjt.mapper.ClassroomMapper;
import com.athjt.service.ClassroomService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassNameClassroomServiceImpl
 * @Description
 * @Author hejiantao
 * @Date2020/8/21 20:20
 * @Version V1.0
 **/
@Service("classroomService")
public class ClassroomServiceImpl  extends  BaseService<Classroom> implements ClassroomService {
	@Resource
	private ClassroomMapper classroomMapper;
	@Override
	public List<Classroom> getClassroomListByCourseId(Integer courseId) {
		Example troleExample = new Example(Classroom.class);
		//tuserExample.or().andIdNotEqualTo(1L);
		Example.Criteria criteria = troleExample.or();
		criteria.andEqualTo("courseId",courseId);
		return classroomMapper.selectByExample(troleExample);
	}
	
	@Override
	public Classroom getClassroomById(Classroom  classroom) {
		return classroomMapper.selectOne(classroom);
	}
}
