package com.hyving.ocean.service;

import com.hyving.ocean.model.request.UserAddReq;
import com.hyving.ocean.model.request.IdReq;

/**
 * @author: Hyving 黄瀚
 * @date: 2020/6/1
 * han.huang@sioeye.com
 * Chengdu Tianfu Software Park
 */
public interface IUserService {
    String addUser(UserAddReq req);

    String getUserInfo(IdReq req);
}
