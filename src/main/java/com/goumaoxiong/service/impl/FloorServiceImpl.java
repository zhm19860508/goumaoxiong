package com.goumaoxiong.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.goumaoxiong.dal.dao.FloorDAO;
import com.goumaoxiong.dal.object.FloorDO;
import com.goumaoxiong.dal.query.FloorQuery;
import com.goumaoxiong.service.FloorService;

public class FloorServiceImpl implements FloorService {

    @Resource(name = "floorDAO")
    private FloorDAO floorDAO;

    @Override
    public Long addNewFloor(FloorDO floorDO) {
        if (floorDO == null) {
            return -1L;
        }
        return floorDAO.addNewFloor(floorDO);
    }

    @Override
    public List<FloorDO> queryAllFloors(FloorQuery floorQuery) {
        List<FloorDO> floorDOs = new ArrayList<FloorDO>();
        if (floorQuery != null) {
            floorDOs = floorDAO.queryAllFloors(floorQuery);
        }
        return floorDOs;
    }

    @Override
    public FloorDO queryFloorById(Long id) {
        FloorDO floorDO = new FloorDO();
        if (id != null && id > 0L) {
            floorDO = floorDAO.queryFloorById(id);
        }
        return floorDO;
    }

    @Override
    public void updateFloor(FloorDO floorDO) {
        if (floorDO != null) {
            floorDAO.updateFloor(floorDO);
        }

    }

}
