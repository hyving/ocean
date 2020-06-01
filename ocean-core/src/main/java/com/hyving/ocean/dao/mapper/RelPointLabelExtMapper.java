package com.hyving.ocean.dao.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

/**
 * @author: Hyving 黄瀚
 * @date: 2020/6/1
 * han.huang@sioeye.com
 * Chengdu Tianfu Software Park
 */
public interface RelPointLabelExtMapper {

    @Delete("delete from pointlabelrelation where point_id=#{pointId}")
    int delRelByPointId(@Param("pointId")String pointId);

    @Delete("delete from pointlabelrelation where label_id=#{labelId}")
    void delRelByLabelId(@Param("labelId") String labelId);
}
