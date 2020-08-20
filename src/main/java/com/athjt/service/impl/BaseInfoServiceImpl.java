package com.athjt.service.impl;

import com.athjt.entity.BaseInfo;
import com.athjt.mapper.BaseInfoMapper;
import com.athjt.service.BaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassNameBaseInfoServiceImpl
 * @Description
 * @Author hejiantao
 * @Date2020/8/20 16:19
 * @Version V1.0
 **/
@Service("baseInfoService")
public class BaseInfoServiceImpl extends BaseService<BaseInfo> implements BaseInfoService {
	@Autowired
	private BaseInfoMapper baseInfoMapper;
}
