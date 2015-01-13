package com.goumaoxiong.dal.dao.impl;

import java.sql.SQLException;

import javax.annotation.Resource;

import com.goumaoxiong.dal.dao.UserDAO;
import com.goumaoxiong.dal.object.UserDO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class UserDAOImpl implements UserDAO {

    @Resource(name = "sqlMapClient")
    private SqlMapClient sqlMapClient;

    @Override
    public Long addNewUser(UserDO userDO) {
        try {
            return (Long) sqlMapClient.insert("ADD_NEW_USER", userDO);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1L;
        }
    }

    @Override
    public UserDO queryUserByUserName(String userName) {

        try {
            return (UserDO) sqlMapClient.queryForObject("QUERY_USER", userName);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
