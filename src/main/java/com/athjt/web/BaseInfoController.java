package com.athjt.web;

import com.alibaba.fastjson.JSONObject;
import com.athjt.entity.BaseInfo;
import com.athjt.entity.Trole;
import com.athjt.model.JqgridBean;
import com.athjt.model.PageRusult;
import com.athjt.service.BaseInfoService;
import com.athjt.util.DateUtil;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.DateFormatter;
import java.text.DateFormat;
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
@RequestMapping("/admin/baseInfo")
public class BaseInfoController {
	
	@Resource
	private BaseInfoService baseInfoService;
	
	@RequestMapping("/getbaseinfolist")
	@RequiresPermissions(value = {"基础信息"})
	public String getbaseinfolist() {
		return "power/baseinfo";
	}
	
	/**
	 * 分页查询角色信息
	 */
	
	@ResponseBody
	@RequestMapping(value = "/list")
	@RequiresPermissions(value = {"基础信息"})
	public Map<String, Object> list(JqgridBean jqgridbean
	) throws Exception {
		LinkedHashMap<String, Object> resultmap = new LinkedHashMap<String, Object>();
		LinkedHashMap<String, Object> datamap = new LinkedHashMap<String, Object>();
		
		Example baseInfoExample = new Example(BaseInfo.class);
		Example.Criteria criteria = baseInfoExample.or();
		
		/*if (StringUtils.isNotEmpty(jqgridbean.getSearchField())) {
			if ("name".equalsIgnoreCase(jqgridbean.getSearchField())) {
				if ("eq".contentEquals(jqgridbean.getSearchOper())) {
					criteria.andEqualTo("name",jqgridbean.getSearchString());
				}
			}
		}*/
		
		PageHelper.startPage(jqgridbean.getPage(), jqgridbean.getLength());
		List<BaseInfo> baseInfoList = baseInfoService.selectByExample(baseInfoExample);
		PageRusult<BaseInfo> pageRusult = new PageRusult<BaseInfo>(baseInfoList);
		
		resultmap.put("currpage", String.valueOf(pageRusult.getPageNum()));
		resultmap.put("totalpages", String.valueOf(pageRusult.getPages()));
		resultmap.put("totalrecords", String.valueOf(pageRusult.getTotal()));
		resultmap.put("datamap", baseInfoList);
		return resultmap;
	}
	
	@ResponseBody
	@RequestMapping(value = "/addupdatebaseinfo")
	@RequiresPermissions(value = {"基础信息"})
	public Map<String, Object> addupdatebaseinfo(@RequestParam String id,
												 @RequestParam String onlyChoice,
												 @RequestParam String checkbox,
												 @RequestParam String selectChoice,
												 @RequestParam String startLiveTime,
												 @RequestParam String endLiveTime,
												 @RequestParam String resourceName,
												 @RequestParam String resourceUploadUrl) {
		LinkedHashMap<String, Object> resultmap = new LinkedHashMap<String, Object>();
		try {
			if (StringUtils.isEmpty(id)) {//新建
				//首先判断用户名是否可用
				//Example baseInfoExample = new Example(BaseInfo.class);
				BaseInfo baseInfo = new BaseInfo();
				baseInfo.setOnlyChoice(onlyChoice);
				baseInfo.setCheckbox(checkbox);
				baseInfo.setSelectChoice(selectChoice);
				baseInfo.setStartLiveTime(DateUtil.parse(startLiveTime,DateUtil.STANDARD_FORMAT));
				baseInfo.setEndLiveTime(DateUtil.parse(endLiveTime,DateUtil.STANDARD_FORMAT));
				baseInfo.setResourceName(resourceName);
				baseInfo.setResourceUploadUrl(resourceUploadUrl);
				baseInfoService.saveNotNull(baseInfo);
			} else {//编辑
				BaseInfo oldObject = baseInfoService.selectByKey(Integer.parseInt(id));
				if (oldObject == null) {
					resultmap.put("state", "fail");
					resultmap.put("mesg", "当前信息不存在");
					return resultmap;
				} else {
					BaseInfo baseInfo = new BaseInfo();
					baseInfo.setOnlyChoice(onlyChoice);
					baseInfo.setCheckbox(checkbox);
					baseInfo.setSelectChoice(selectChoice);
					baseInfo.setStartLiveTime(DateUtil.parse(startLiveTime,DateUtil.STANDARD_FORMAT));
					baseInfo.setEndLiveTime(DateUtil.parse(endLiveTime,DateUtil.STANDARD_FORMAT));
					baseInfo.setResourceName(resourceName);
					baseInfo.setResourceUploadUrl(resourceUploadUrl);
					baseInfo.setId(oldObject.getId());
					baseInfoService.updateNotNull(baseInfo);
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
	@RequestMapping(value = "/selectBaseInfoById")
	@RequiresPermissions(value = {"角色管理"})
	public Map<String, Object> selectBaseInfoById(BaseInfo baseInfo) {
		LinkedHashMap<String, Object> resultmap = new LinkedHashMap<String, Object>();
		try {
			if (baseInfo.getId() != null && !baseInfo.getId().equals(0)) {
				baseInfo = baseInfoService.selectByKey(baseInfo.getId());
				if (baseInfo == null) {
					resultmap.put("state", "fail");
					resultmap.put("mesg", "无法找到该记录");
					return resultmap;
				}
			} else {
				resultmap.put("state", "fail");
				resultmap.put("mesg", "无法找到该记录的id");
				return resultmap;
			}
			
			resultmap.put("baseInfo", baseInfo);
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
