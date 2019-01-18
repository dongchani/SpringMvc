package com.app.dao;

import com.commons.entity.TsyMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TsyMenuMapper {
    int deleteByPrimaryKey(Integer menuId);

    int insert(TsyMenu record);

    int insertSelective(TsyMenu record);

    TsyMenu selectByPrimaryKey(Integer menuId);

    int updateByPrimaryKeySelective(TsyMenu record);

    int updateByPrimaryKey(TsyMenu record);

    List<TsyMenu> selectByParentId(@Param("parentId") Integer parentId);
}