package com.hyving.ocean.service;

import com.hyving.ocean.model.request.LabelAddReq;
import com.hyving.ocean.model.request.PointAddReq;
import com.hyving.ocean.model.request.IdReq;
import com.hyving.ocean.model.request.PointUpdateReq;

/**
 * @author: Hyving 黄瀚
 * @date: 2020/6/1
 * han.huang@sioeye.com
 * Chengdu Tianfu Software Park
 */
public interface IPointService {
    String addLabel(LabelAddReq req);

    String getUserLabels(IdReq req);

    String addPoint(PointAddReq req);

    String delPoint(IdReq req);

    String delLabel(IdReq req);

    String updatePoint(PointUpdateReq req);
}
