package com.goumaoxiong.dal.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.goumaoxiong.dal.dao.FloorDAO;
import com.goumaoxiong.dal.object.FloorDO;
import com.goumaoxiong.dal.query.FloorQuery;
import com.ibatis.sqlmap.client.SqlMapClient;

public class FloorDAOImpl implements FloorDAO {

    @Resource(name = "sqlMapClient")
    private SqlMapClient sqlMapClient;

    @Override
    public Long addNewFloor(FloorDO floorDO) {

        try {
            return (Long) sqlMapClient.insert("ADD_NEW_FLOOR", floorDO);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1L;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<FloorDO> queryAllFloors(FloorQuery floorQuery) {
        List<FloorDO> floors = new ArrayList<FloorDO>();
        try {
            floors = sqlMapClient.queryForList("QUERY_ALL_FLOORS", floorQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return floors;
    }

    @Override
    public FloorDO queryFloorById(Long id) {
        FloorDO floorDO = new FloorDO();
        try {
            floorDO = (FloorDO) sqlMapClient.queryForObject("QUERY_FLOOR_BY_ID", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return floorDO;
    }

    @Override
    public void updateFloor(FloorDO floorDO) {
        try {
            sqlMapClient.update("UPDATE_FLOOR", floorDO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
