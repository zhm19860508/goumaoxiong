package com.goumaoxiong.dal.dao.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.goumaoxiong.dal.dao.UserDAO;
import com.goumaoxiong.dal.object.UserDO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class UserDAOImpl implements UserDAO {

    @Autowired
    // @Qualifier("sqlMapClient")
    private SqlMapClient sqlMapClient;

    @Override
    public Long addNewUser(UserDO userDO) {
        try {
            return (Long) sqlMapClient.insert("ADD_NEW_USER", userDO);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return -1L;
        }
    }

    @Override
    public UserDO queryUserByUserName(String userName) {
        // TODO Auto-generated method stub
        return null;
    }

}
