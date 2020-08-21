package com.athjt.web;

import com.athjt.entity.BaseInfo;
import com.athjt.entity.Student;
import com.athjt.model.JqgridBean;
import com.athjt.model.PageRusult;
import com.athjt.service.BaseInfoService;
import com.athjt.service.StudentService;
import com.athjt.util.DateUtil;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
		
		/*if (StringUtils.isNotEmpty(jqgridbean.getSearchField())) {
			if ("name".equalsIgnoreCase(jqgridbean.getSearchField())) {
				if ("eq".contentEquals(jqgridbean.getSearchOper())) {
					criteria.andEqualTo("name",jqgridbean.getSearchString());
				}
			}
		}*/
		
		PageHelper.startPage(jqgridbean.getPage(), jqgridbean.getLength());
		List<Student> studentList = studentService.selectByExample(studentExample);
		PageRusult<Student> pageRusult = new PageRusult<Student>(studentList);
		
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
	public Map<String, Object> selectBaseInfoById(Student student) {
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
			
			resultmap.put("baseInfo", student);
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
	
}
