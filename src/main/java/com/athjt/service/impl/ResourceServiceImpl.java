package com.athjt.service.impl;

import com.athjt.entity.Resource;
import com.athjt.mapper.ResourceMapper;
import com.athjt.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassNameResourceServiceImpl
 * @Description
 * @Author hejiantao
 * @Date2020/8/20 16:19
 * @Version V1.0
 **/
@Service("resourceService")
public class ResourceServiceImpl  extends BaseService<Resource> implements ResourceService {
	@Autowired
	private ResourceMapper resourceMapper;
}
