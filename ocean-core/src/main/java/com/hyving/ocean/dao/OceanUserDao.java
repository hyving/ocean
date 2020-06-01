package com.hyving.ocean.dao;

import com.hyving.ocean.dao.mapper.OceanUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author: Hyving 黄瀚
 * @date: 2020/6/1
 * han.huang@sioeye.com
 * Chengdu Tianfu Software Park
 */
@Repository
public class OceanUserDao {

    @Resource
    private OceanUserMapper mapper;

    public OceanUserMapper getInstance(){
        return this.mapper;
    }



}
