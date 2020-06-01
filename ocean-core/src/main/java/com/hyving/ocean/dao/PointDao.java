package com.hyving.ocean.dao;

import com.hyving.ocean.dao.mapper.*;
import com.hyving.ocean.model.entity.PointLabel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

/**
 * @author: Hyving 黄瀚
 * @date: 2020/6/1
 * han.huang@sioeye.com
 * Chengdu Tianfu Software Park
 */
@Repository
public class PointDao {


    @Resource
    private PointLabelMapper labelMapper;
    @Resource
    private PointMapper pointMapper;
    @Resource
    private RelPointLabelMapper relMapper;
    @Resource
    private PointLabelExtMapper labelExtMapper;
    @Resource
    private PointExtMapper pointExtMapper;

    @Resource
    private RelPointLabelExtMapper relExtMapper;

    public PointLabelMapper labelInstance(){
        return this.labelMapper;
    }

    public PointMapper pointInstance(){
        return this.pointMapper;
    }

    public RelPointLabelMapper relInstance(){
        return this.relMapper;
    }

    public PointLabelExtMapper labelExtInstance(){
        return this.labelExtMapper;
    }


    public PointExtMapper pointExtInstance(){
        return this.pointExtMapper;
    }

    public RelPointLabelExtMapper relExtMapper(){
        return this.relExtMapper;
    }

}
