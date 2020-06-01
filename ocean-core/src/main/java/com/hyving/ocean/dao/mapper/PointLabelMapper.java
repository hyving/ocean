package com.hyving.ocean.dao.mapper;

import com.hyving.ocean.model.entity.PointLabel;

public interface PointLabelMapper {
    int deleteByPrimaryKey(String id);

    int insert(PointLabel record);

    int insertSelective(PointLabel record);

    PointLabel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PointLabel record);

    int updateByPrimaryKey(PointLabel record);
}