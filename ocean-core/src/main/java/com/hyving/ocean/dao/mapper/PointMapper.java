package com.hyving.ocean.dao.mapper;

import com.hyving.ocean.model.entity.Point;

public interface PointMapper {
    int deleteByPrimaryKey(String id);

    int insert(Point record);

    int insertSelective(Point record);

    Point selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Point record);

    int updateByPrimaryKeyWithBLOBs(Point record);

    int updateByPrimaryKey(Point record);
}