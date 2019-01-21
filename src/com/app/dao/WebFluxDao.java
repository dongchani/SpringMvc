package com.app.dao;

import com.commons.entity.TsyUser;

import java.util.List;

public interface WebFluxDao {
  List<TsyUser> selectAll();
}
