package com.app.dao;

import com.commons.entity.TsyRole;

public interface TsyRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TsyRole record);

    int insertSelective(TsyRole record);

    TsyRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TsyRole record);

    int updateByPrimaryKey(TsyRole record);
}