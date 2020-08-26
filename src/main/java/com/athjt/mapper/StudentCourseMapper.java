/* https://github.com/orange1438 */
package com.athjt.mapper;

import com.athjt.entity.StudentCourse;
import com.athjt.util.MyMapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 本文件由 https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation 自动生成
 * @author orange1438 code generator
 * date:2020/08/24 16:50
 */

public interface StudentCourseMapper extends BaseMapper<StudentCourse>, MyMapper<StudentCourse> {
	
	List<StudentCourse> selectStudentCourseList();
}