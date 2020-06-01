package com.hyving.ocean.service.impl;

import com.alibaba.fastjson.JSON;
import com.hyving.ocean.dao.OceanUserDao;
import com.hyving.ocean.model.entity.OceanUser;
import com.hyving.ocean.model.request.UserAddReq;
import com.hyving.ocean.model.request.IdReq;
import com.hyving.ocean.service.IUserService;
import com.hyving.ocean.utils.IdTools;
import com.hyving.ocean.utils.SecretTools;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @author: Hyving 黄瀚
 * @date: 2020/6/1
 * han.huang@sioeye.com
 * Chengdu Tianfu Software Park
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private OceanUserDao dao;

    @Override
    public String addUser(UserAddReq req) {
        //参数检查
        checkConfirm(req.getPassword(),req.getConfirmPassword());

        //赋值
        OceanUser temp =new OceanUser();
        BeanUtils.copyProperties(req,temp);

        String userId=IdTools.getUUID();
        String salt = SecretTools.generateSecret(6);

        temp.setSalt(salt);
        temp.setPassword(SecretTools.md5(req.getPassword()+salt));
        temp.setCreateTime(new Date());
        temp.setUpdateTime(new Date());
        temp.setStatus((byte) 0);

        temp.setId(userId);
        //插入
        dao.getInstance().insert(temp);

        return JSON.toJSONString(dao.getInstance().selectByPrimaryKey(userId));
    }


    private void checkConfirm(String password, String confirmPassword) {
        if(StringUtils.isEmpty(password)||StringUtils.isEmpty(confirmPassword)){
            //todo
        }

        if(!password.equals(confirmPassword)){
            //todo
        }
    }



    @Override
    public String getUserInfo(IdReq req) {
        return JSON.toJSONString(dao.getInstance().selectByPrimaryKey(req.getId()));
    }
}
