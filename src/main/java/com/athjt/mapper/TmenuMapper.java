package com.athjt.mapper;

import com.athjt.entity.Tmenu;
import com.athjt.util.MyMapper;

import java.util.HashMap;
import java.util.List;

public interface TmenuMapper extends MyMapper<Tmenu> {

    List<Tmenu> selectMenusByRoleId(Integer roleid);

    List<Tmenu> selectByParentIdAndRoleId(HashMap<String,Object> paraMap);

}