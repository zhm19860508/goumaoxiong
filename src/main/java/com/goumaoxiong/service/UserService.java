package com.goumaoxiong.service;

import com.goumaoxiong.dal.object.UserDO;

public interface UserService {

    public Long addNewUser(UserDO userDO);

    public UserDO queryUserByUserName(String userName);

}
