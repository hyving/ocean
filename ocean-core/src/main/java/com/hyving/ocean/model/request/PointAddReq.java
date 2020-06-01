package com.hyving.ocean.model.request;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author: Hyving 黄瀚
 * @date: 2020/6/1
 * han.huang@sioeye.com
 * Chengdu Tianfu Software Park
 */
@Data
public class PointAddReq {

    private String userId;

    private String question;

    private String answer;

    private String remark;

    private List<String> labels;

}
