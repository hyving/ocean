package com.hyving.ocean.controller;

import com.hyving.ocean.model.request.LabelAddReq;
import com.hyving.ocean.model.request.PointAddReq;
import com.hyving.ocean.model.request.IdReq;
import com.hyving.ocean.model.request.PointUpdateReq;
import com.hyving.ocean.service.IPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Hyving 黄瀚
 * @date: 2020/6/1
 * han.huang@sioeye.com
 * Chengdu Tianfu Software Park
 */
@RestController
@RequestMapping("/point")
public class PointController {
    @Autowired
    private IPointService service;

    /**
     * 添加标签
     * @param req
     * @return
     */
    @PostMapping("/add-label")
    public String addLabel(@RequestBody LabelAddReq req){
        return service.addLabel(req);
    }
    @PostMapping("/del-label")
    public String delLabel(@RequestBody IdReq req){
        return service.delLabel(req);
    }

    /**
     * 获得用户所有标签
     * @param req
     * @return
     */
    @PostMapping("/label-list")
    public String getUserLabel(@RequestBody IdReq req){
        return service.getUserLabels(req);
    }

    /**
     * 添加问题
     * @param req
     * @return
     */
    @PostMapping("/add-point")
    public String addPoint(@RequestBody PointAddReq req){
        return service.addPoint(req);
    }

    /**
     * 删除问题
     * @param req
     * @return
     */
    @PostMapping("/del-point")
    public String delPoint(@RequestBody IdReq req){
        return service.delPoint(req);
    }

    /**
     * 修改问题
     * @param req
     * @return
     */
    @PostMapping("/upd_point")
    public String updatePoint(@RequestBody PointUpdateReq req){

        return service.updatePoint(req);
    }





}
