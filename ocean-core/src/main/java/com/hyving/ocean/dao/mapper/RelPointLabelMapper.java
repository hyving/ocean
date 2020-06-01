package com.hyving.ocean.dao.mapper;

import com.hyving.ocean.model.entity.RelPointLabel;

public interface RelPointLabelMapper {
    int deleteByPrimaryKey(String id);

    int insert(RelPointLabel record);

    int insertSelective(RelPointLabel record);

    RelPointLabel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RelPointLabel record);

    int updateByPrimaryKey(RelPointLabel record);
}