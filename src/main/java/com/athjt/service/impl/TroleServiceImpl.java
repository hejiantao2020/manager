package com.athjt.service.impl;

import com.athjt.entity.Trole;
import com.athjt.mapper.TroleMapper;
import com.athjt.service.TroleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hejinatao
 * @version 1.0, 2020-08-20
 * @description
 */

@Service("troleService")
public class TroleServiceImpl   extends BaseService<Trole> implements TroleService {
    @Autowired
    private TroleMapper troleMapper;

    @Override
    public List<Trole> selectRolesByUserId(Integer userid) {
        return troleMapper.selectRolesByUserId(userid);
    }
}
