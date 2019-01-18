package com.app.dao;

import com.commons.entity.TsyMenu;
import com.commons.entity.TsyUser;
import org.apache.ibatis.annotations.Param;

public interface TsyUserMapper {
/*    TsyUser selectUsername(@Param("username") String username);*/
    TsyUser selectUsername1(@Param("username") String username);


}