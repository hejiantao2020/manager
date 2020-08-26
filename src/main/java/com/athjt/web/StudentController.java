package com.athjt.web;

import com.athjt.entity.*;
import com.athjt.model.JqgridBean;
import com.athjt.model.PageRusult;
import com.athjt.service.*;
import com.athjt.util.DateUtil;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassNameBaseInfoController
 * @Description
 * @Author hejiantao
 * @Date2020/8/20 16:22
 * @Version V1.0
 **/
@Controller
@RequestMapping("/admin/student")
public class StudentController {
	
	@Resource
	private StudentService studentService;
	@Resource
	private CourseService courseService;
	@Resource
	private ClassroomService classroomService;
	@Resource
	private StudentCourseService studentCourseService;
	@RequestMapping("/getstudentlist")
	@RequiresPermissions(value = {"学生信息"})
	public String getstudentlist() {
		return "power/student";
	}
	
	/**
	 * 分页查询角色信息
	 */
	
	@ResponseBody
	@RequestMapping(value = "/list")
	@RequiresPermissions(value = {"学生信息"})
	public Map<String, Object> list(JqgridBean jqgridbean
	) throws Exception {
		LinkedHashMap<String, Object> resultmap = new LinkedHashMap<String, Object>();
		LinkedHashMap<String, Object> datamap = new LinkedHashMap<String, Object>();
		Example studentExample = new Example(Student.class);
		Example.Criteria criteria = studentExample.or();
		criteria.andNotEqualTo("deleted",1);

		/*if (StringUtils.isNotEmpty(jqgridbean.getSearchField())) {
			if ("name".equalsIgnoreCase(jqgridbean.getSearchField())) {
				if ("eq".contentEquals(jqgridbean.getSearchOper())) {
					criteria.andEqualTo("name",jqgridbean.getSearchString());
				}
			}
		}*/
		
		PageHelper.startPage(jqgridbean.getPage(), jqgridbean.getLength());
		List<Student> studentList = studentService.selectByExample(studentExample);
//		List<StudentCourse> studentCourseList =studentCourseService.queryStudentCourseList();
		PageRusult<Student> pageRusult = new PageRusult<>(studentList);
		
		resultmap.put("currpage", String.valueOf(pageRusult.getPageNum()));
		resultmap.put("totalpages", String.valueOf(pageRusult.getPages()));
		resultmap.put("totalrecords", String.valueOf(pageRusult.getTotal()));
		resultmap.put("datamap", studentList);
		return resultmap;
	}
	
	@ResponseBody
	@RequestMapping(value = "/addupdatestudent")
	@RequiresPermissions(value = {"学生信息"})
	public Map<String, Object> addupdatestudent(Student student) {
		LinkedHashMap<String, Object> resultmap = new LinkedHashMap<String, Object>();
		try {
			if (student.getId() == null || ("").equals(student.getId())) {//新建
				student.setCreateTime(new Date());
				studentService.saveNotNull(student);
			} else {//编辑
				Student oldObject = studentService.selectByKey(student.getId());
				if (oldObject == null) {
					resultmap.put("state", "fail");
					resultmap.put("mesg", "当前信息不存在");
					return resultmap;
				} else {
					student.setId(oldObject.getId());
					student.setUpdateTime(new Date());
					studentService.updateNotNull(student);
				}
			}
			resultmap.put("state", "success");
			resultmap.put("mesg", "操作成功");
			return resultmap;
		} catch (DuplicateKeyException exception){
			exception.printStackTrace();
			resultmap.put("state", "fail");
			resultmap.put("mesg", "数据库已存在改手机号的数据");
			return resultmap;
		} catch (Exception e) {
			e.printStackTrace();
			resultmap.put("state", "fail");
			resultmap.put("mesg", "操作失败，系统异常");
			return resultmap;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/selectStudentById")
	@RequiresPermissions(value = {"学生信息"})
	public Map<String, Object> selectStudentById(Student student) {
		LinkedHashMap<String, Object> resultmap = new LinkedHashMap<String, Object>();
		try {
			if (student.getId() != null && !student.getId().equals(0)) {
				student = studentService.selectByKey(student.getId());
				if (student == null) {
					resultmap.put("state", "fail");
					resultmap.put("mesg", "无法找到该记录");
					return resultmap;
				}
			} else {
				resultmap.put("state", "fail");
				resultmap.put("mesg", "无法找到该记录的id");
				return resultmap;
			}
			
			resultmap.put("student", student);
			resultmap.put("state", "success");
			resultmap.put("mesg", "获取成功");
			return resultmap;
		} catch (Exception e) {
			e.printStackTrace();
			resultmap.put("state", "fail");
			resultmap.put("mesg", "获取失败，系统异常");
			return resultmap;
		}
	}
	@ResponseBody
	@RequestMapping(value = "/getCourseList")
	@RequiresPermissions(value = {"学生信息"})
	public Map<String, Object> getCourseList() {
		LinkedHashMap<String, Object> resultmap = new LinkedHashMap<String, Object>();
		try {
				Object example=new Course();
				List<Course> courseList = courseService.getCourseList();
				if (courseList == null || courseList.size()==0) {
					resultmap.put("state", "fail");
					resultmap.put("mesg", "么有找到课程记录");
					return resultmap;
				}
			resultmap.put("courseList", courseList);
			resultmap.put("state", "success");
			resultmap.put("mesg", "获取成功");
			return resultmap;
		} catch (Exception e) {
			e.printStackTrace();
			resultmap.put("state", "fail");
			resultmap.put("mesg", "获取失败，系统异常");
			return resultmap;
		}
	}
	@ResponseBody
	@RequestMapping(value = "/getClassroomListByCourseId")
	@RequiresPermissions(value = {"学生信息"})
	public Map<String, Object> getClassroomListByCourseId(@RequestParam Integer courseId) {
		LinkedHashMap<String, Object> resultmap = new LinkedHashMap<String, Object>();
		try {
			Object example=new Course();
			List<Classroom> classroomList = classroomService.getClassroomListByCourseId(courseId);
			if (classroomList == null || classroomList.size()==0) {
				resultmap.put("state", "fail");
				resultmap.put("mesg", "么有找到课程记录");
				return resultmap;
			}
			resultmap.put("classroomList", classroomList);
			resultmap.put("state", "success");
			resultmap.put("mesg", "获取成功");
			return resultmap;
		} catch (Exception e) {
			e.printStackTrace();
			resultmap.put("state", "fail");
			resultmap.put("mesg", "获取失败，系统异常");
			return resultmap;
		}
	}
	@ResponseBody
	@RequestMapping(value = "/deletestudent")
	@RequiresPermissions(value = {"学生信息"})
	public Map<String, Object> deletestudent(Student student) {
		LinkedHashMap<String, Object> resultmap = new LinkedHashMap<String, Object>();
		try {
			if (student.getId() != null && !student.getId().equals(0)) {
				student = studentService.selectByKey(student.getId());
				if (student == null) {
					resultmap.put("state", "fail");
					resultmap.put("mesg", "删除失败,无法找到该记录");
					return resultmap;
				} else {
					student.setDeleted(1);
					student.setUpdateTime(new Date());
					studentService.updateNotNull(student);
//					List<StudentCourse> studentCourses = studentCourseService.queryStudentCourseListByStudentId(student.getId());
//					if (studentCourses !=null && studentCourses.size()>0){
//						for (StudentCourse studentCourse:studentCourses) {
//							studentCourse.setDeleted(Byte.valueOf("1"));
//							studentCourse.setStudentId(student.getId());
//							studentCourse.setUpdateTime(new Date());
//							studentCourseService.updateStudentCourse(studentCourse);
//						}
//					}
				}
			} else {
				resultmap.put("state", "fail");
				resultmap.put("mesg", "删除失败");
			}
			
			
			resultmap.put("state", "success");
			resultmap.put("mesg", "删除成功");
			return resultmap;
		} catch (Exception e) {
			e.printStackTrace();
			resultmap.put("state", "fail");
			resultmap.put("mesg", "删除失败，系统异常");
			return resultmap;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/addupdatestudentBuyCourse")
	@RequiresPermissions(value = {"学生信息"})
	public Map<String, Object> addupdatestudentBuyCourse(Student student) {
		LinkedHashMap<String, Object> resultmap = new LinkedHashMap<String, Object>();
		try {
			if (student.getId() != null && !("").equals(student.getId()) &&
					student.getCourseId() !=null && !("").equals(student.getCourseId()) &&
					student.getClassroomId() !=null && !("").equals(student.getClassroomId())){
				int count = studentCourseService.queryCourseBystuIdAndCourseIdAndRoomId(student.getId(), student.getCourseId(), student.getClassroomId());
			    if (count>0){
					resultmap.put("state", "fail");
					resultmap.put("mesg", "该课程学生已购买");
					return resultmap;
				}
			}
			
			StudentCourse studentCourse = new StudentCourse();
			if (student.getId() != null && !("").equals(student.getId()) ) {//新建
				if (student.getCourseId() !=null && !("").equals(student.getCourseId())){
					//获取课程名称和班级名称
					Course course = new Course();
					course.setId(student.getCourseId());
					course = courseService.getCourseById(course);
					if (course !=null) {
						studentCourse.setCourseId(course.getId());
						studentCourse.setCourseName(course.getName());
					}
				}
				if (student.getClassroomId() !=null && !("").equals(student.getClassroomId())){
					Classroom  classroom = new Classroom();
					classroom.setId(student.getClassroomId());
					classroom = classroomService.getClassroomById(classroom);
					if (classroom != null){
						studentCourse.setClassroomId(classroom.getId());
						studentCourse.setClassroomName(classroom.getClassName());
					}
				}
				studentCourse.setStudentId(student.getId());
				studentCourse.setUpdateTime(new Date());
				studentCourse.setBuyStatus(1);
				studentCourse.setCreateTime(new Date());
				studentCourse.setDeleted(Byte.valueOf("0"));
				studentCourseService.saveStudentCourse(studentCourse);
			}
			resultmap.put("state", "success");
			resultmap.put("mesg", "操作成功");
			return resultmap;
		} catch (Exception e) {
			e.printStackTrace();
			resultmap.put("state", "fail");
			resultmap.put("mesg", "操作失败，系统异常");
			return resultmap;
		}
	}
	@RequestMapping("/getstudentcourselist")
	@RequiresPermissions(value = {"学生信息"})
	public String getstudentcourselist() {
		return "power/studentCourseList";
	}
	
	
	/**
	 * 分页查询角色信息
	 */
	
	@ResponseBody
	@RequestMapping(value = "/studentcourselist")
	@RequiresPermissions(value = {"学生信息"})
	public Map<String, Object> studentcourselist(JqgridBean jqgridbean
	) throws Exception {
		LinkedHashMap<String, Object> resultmap = new LinkedHashMap<String, Object>();
		LinkedHashMap<String, Object> datamap = new LinkedHashMap<String, Object>();
		Example studentExample = new Example(StudentCourse.class);
		Example.Criteria criteria = studentExample.or();

		/*if (StringUtils.isNotEmpty(jqgridbean.getSearchField())) {
			if ("name".equalsIgnoreCase(jqgridbean.getSearchField())) {
				if ("eq".contentEquals(jqgridbean.getSearchOper())) {
					criteria.andEqualTo("name",jqgridbean.getSearchString());
				}
			}
		}*/
		
		PageHelper.startPage(jqgridbean.getPage(), jqgridbean.getLength());
		//List<StudentCourse> studentList = studentCourseService.selectByExample(studentExample);
		List<StudentCourse> studentCourseList =studentCourseService.queryStudentCourseList();
		PageRusult<StudentCourse> pageRusult = new PageRusult<>(studentCourseList);
		
		resultmap.put("currpage", String.valueOf(pageRusult.getPageNum()));
		resultmap.put("totalpages", String.valueOf(pageRusult.getPages()));
		resultmap.put("totalrecords", String.valueOf(pageRusult.getTotal()));
		resultmap.put("datamap", studentCourseList);
		return resultmap;
	}
}
