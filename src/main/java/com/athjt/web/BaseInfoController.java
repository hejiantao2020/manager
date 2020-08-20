package com.athjt.web;

import com.athjt.entity.BaseInfo;
import com.athjt.entity.Trole;
import com.athjt.model.JqgridBean;
import com.athjt.model.PageRusult;
import com.athjt.service.BaseInfoService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
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
	@RequiresPermissions(value = {"角色管理"})
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
		PageRusult<BaseInfo> pageRusult =new PageRusult<BaseInfo>(baseInfoList);
		
		resultmap.put("currpage", String.valueOf(pageRusult.getPageNum()));
		resultmap.put("totalpages", String.valueOf(pageRusult.getPages()));
		resultmap.put("totalrecords", String.valueOf(pageRusult.getTotal()));
		resultmap.put("datamap", baseInfoList);
		return resultmap;
	}
	
}
