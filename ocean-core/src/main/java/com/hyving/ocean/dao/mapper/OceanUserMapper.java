package com.hyving.ocean.dao.mapper;

import com.hyving.ocean.model.entity.OceanUser;

public interface OceanUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(OceanUser record);

    int insertSelective(OceanUser record);

    OceanUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OceanUser record);

    int updateByPrimaryKey(OceanUser record);
}