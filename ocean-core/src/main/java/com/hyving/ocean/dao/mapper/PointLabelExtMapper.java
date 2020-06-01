package com.hyving.ocean.dao.mapper;

import com.hyving.ocean.model.entity.PointLabel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: Hyving 黄瀚
 * @date: 2020/6/1
 * han.huang@sioeye.com
 * Chengdu Tianfu Software Park
 */
public interface PointLabelExtMapper {


    @Select("select * from label where label =#{label} and user_id=#{userId}")
    PointLabel getLabelByNameAndUser(@Param("label") String label, @Param("userId") String userId);

    @Select("select * from label where user_id=#{userId}")
    List<PointLabel> getLabelByUser(@Param("userId") String userId);
    @Delete("delete from label where label_id=#{labelId}")
    void delLabelById(@Param("labelId")String labelId);
}
