package com.hyving.ocean.dao.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

/**
 * @author: Hyving 黄瀚
 * @date: 2020/6/1
 * han.huang@sioeye.com
 * Chengdu Tianfu Software Park
 */
public interface PointExtMapper {

    @Delete("delete from point where id =#{pointId}")
    int delPointById(@Param("pointId")String id);
}
