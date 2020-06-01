package com.hyving.ocean.model.request;

import lombok.Data;

/**
 * @author: Hyving 黄瀚
 * @date: 2020/6/1
 * han.huang@sioeye.com
 * Chengdu Tianfu Software Park
 */
@Data
public class UserAddReq {

    private String name;
    private String password;
    private String confirmPassword;
    private String mobile;

}
