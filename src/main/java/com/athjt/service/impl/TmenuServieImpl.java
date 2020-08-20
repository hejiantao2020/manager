package com.athjt.service.impl;

import com.athjt.entity.Tmenu;
import com.athjt.mapper.TmenuMapper;
import com.athjt.service.TmenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author hejinatao
 * @version 1.0, 2020-08-20
 * @description
 */
@Service("tmenuService")
public class TmenuServieImpl extends BaseService<Tmenu> implements TmenuService {
    @Autowired
    private TmenuMapper tmenuMapper;

    @Override
    public List<Tmenu> selectMenusByRoleId(Integer roleid) {
        return tmenuMapper.selectMenusByRoleId(roleid);
    }

    @Override
    public List<Tmenu> selectByParentIdAndRoleId(HashMap<String, Object> paraMap) {
        return tmenuMapper.selectByParentIdAndRoleId(paraMap);
    }
}
