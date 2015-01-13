package com.goumaoxiong.home.module.screen;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.goumaoxiong.dal.dao.UserDAO;
import com.goumaoxiong.dal.object.UserDO;

public class Index {

    @Autowired
    private UserDAO userDAO;

    public void execute(Context context) {
//        UserDO userDO = new UserDO();
//        userDO.setNick("D&Z");
//        userDO.setUserName("lizzie");
//        userDO.setPassword("0511");
//        Long id = userDAO.addNewUser(userDO);
//        context.put("name", id);
    }

}
