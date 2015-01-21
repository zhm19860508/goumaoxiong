package com.goumaoxiong.web.home.module.screen;

import javax.annotation.Resource;

import com.alibaba.citrus.turbine.Context;
import com.goumaoxiong.dal.dao.UserDAO;

public class Index {

    @Resource(name="userDAO")
    private UserDAO userDAO;

    public void execute(Context context) {
        // UserDO userDO = new UserDO();
        // userDO.setNick("D&Z");
        // userDO.setUserName("lizzie");
        // userDO.setPassword("0511");
        // Long id = userDAO.addNewUser(userDO);
        // context.put("name", id);
    }

}
