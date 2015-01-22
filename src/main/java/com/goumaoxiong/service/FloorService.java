package com.goumaoxiong.service;

import java.util.List;

import com.goumaoxiong.dal.object.FloorDO;
import com.goumaoxiong.dal.query.FloorQuery;

public interface FloorService {

    public Long addNewFloor(FloorDO floorDO);

    public List<FloorDO> queryAllFloors(FloorQuery floorQuery);

    public FloorDO queryFloorById(Long id);

    public void updateFloor(FloorDO floorDO);
}
