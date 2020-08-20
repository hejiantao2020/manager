package com.athjt.mapper;

import com.athjt.entity.Trole;
import com.athjt.util.MyMapper;

import java.util.List;

public interface TroleMapper extends MyMapper<Trole> {

    List<Trole> selectRolesByUserId(Integer userid);

}