package com.goumaoxiong.dal.dao;

import com.goumaoxiong.dal.object.UserDO;

public interface UserDAO {

    public Long addNewUser(UserDO userDO);

    public UserDO queryUserByUserName(String userName);

}
