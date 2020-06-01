package com.hyving.ocean.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.hyving.ocean.dao.PointDao;
import com.hyving.ocean.model.entity.Point;
import com.hyving.ocean.model.entity.PointLabel;
import com.hyving.ocean.model.entity.RelPointLabel;
import com.hyving.ocean.model.request.LabelAddReq;
import com.hyving.ocean.model.request.PointAddReq;
import com.hyving.ocean.model.request.IdReq;
import com.hyving.ocean.model.request.PointUpdateReq;
import com.hyving.ocean.service.IPointService;
import com.hyving.ocean.utils.IdTools;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author: Hyving 黄瀚
 * @date: 2020/6/1
 * han.huang@sioeye.com
 * Chengdu Tianfu Software Park
 */
@Service
public class PointService implements IPointService {

    @Resource
    private PointDao dao;


    @Override
    public String addLabel(LabelAddReq req) {

        //检查是否存在
        PointLabel label =dao.labelExtInstance().getLabelByNameAndUser(req.getLabel(),req.getUserId());

        if(label ==null){

            PointLabel temp =new PointLabel();
            BeanUtils.copyProperties(req,temp);
            String id = IdTools.getUUID();

            temp.setCreateTime(new Date());
            temp.setId(id);

            dao.labelInstance().insert(temp);

            return JSON.toJSONString(dao.labelInstance().selectByPrimaryKey(id));
        }else{

            return JSON.toJSONString(label);
        }
    }

    @Override
    public String getUserLabels(IdReq req) {

        List<PointLabel> list =dao.labelExtInstance().getLabelByUser(req.getId());
        return JSONArray.toJSONString(list);

    }

    @Override
    public String addPoint(PointAddReq req) {

        Point point =new Point();

        BeanUtils.copyProperties(req,point);
        Date current =new Date();
        String pointId =IdTools.getUUID();
        point.setCreateTime(current);
        point.setUpdateTime(current);
        point.setId(pointId);

        dao.pointInstance().insert(point);

        if(!CollectionUtils.isEmpty(req.getLabels())){
            List<String> labels =req.getLabels();
            List<String> relIds =IdTools.getUUIDList(labels.size());
            for(int i=0;i<labels.size();i++){

                RelPointLabel r =new RelPointLabel();
                r.setId(relIds.get(i));
                r.setPointId(pointId);
                r.setLabelId(labels.get(i));
                dao.relInstance().insert(r);
            }
        }

        return JSON.toJSONString(dao.pointInstance().selectByPrimaryKey(pointId));
    }

    @Override
    public String delPoint(IdReq req) {

        dao.pointExtInstance().delPointById(req.getId());

        dao.relExtMapper().delRelByPointId(req.getId());

        return "success";
    }

    @Override
    public String delLabel(IdReq req) {
        dao.labelExtInstance().delLabelById(req.getId());

        dao.relExtMapper().delRelByLabelId(req.getId());

        return "success";
    }

    @Override
    public String updatePoint(PointUpdateReq req) {

        Point record =dao.pointInstance().selectByPrimaryKey(req.getPointId());
        if(record ==null){
            return "";//todo
        }

        BeanUtils.copyProperties(req,record);
        record.setUpdateTime(new Date());

        dao.pointInstance().updateByPrimaryKeySelective(record);

        dao.relExtMapper().delRelByPointId(req.getPointId());

        if(!CollectionUtils.isEmpty(req.getLabels())){
            List<String> labels =req.getLabels();
            List<String> relIds =IdTools.getUUIDList(labels.size());
            for(int i=0;i<labels.size();i++){

                RelPointLabel r =new RelPointLabel();
                r.setId(relIds.get(i));
                r.setPointId(req.getPointId());
                r.setLabelId(labels.get(i));
                dao.relInstance().insert(r);
            }
        }

        return  JSON.toJSONString(dao.pointInstance().selectByPrimaryKey(req.getPointId()));
    }
}
