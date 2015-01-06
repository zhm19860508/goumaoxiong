package com.goumaoxiong.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.goumaoxiong.dal.dao.UserDAO;
import com.goumaoxiong.dal.object.UserDO;
import com.goumaoxiong.service.UserService;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public Long addNewUser(UserDO userDO) {
        if (userDO == null) {
            return -1L;
        }
        return userDAO.addNewUser(userDO);
    }

    @Override
    public UserDO queryUserByUserName(String userName) {
        UserDO userDO = new UserDO();
        if (StringUtils.isNotBlank(userName)) {
            userDO = userDAO.queryUserByUserName(userName);
        }
        return userDO;
    }

}
