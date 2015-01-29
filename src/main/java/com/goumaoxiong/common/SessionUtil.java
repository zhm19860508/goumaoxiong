package com.goumaoxiong.common;

import javax.servlet.http.HttpSession;

import com.goumaoxiong.dal.object.UserDO;

public class SessionUtil {

    public static boolean isLogin(HttpSession session) {
        UserDO userDO = (UserDO) session.getAttribute(GmxConstants.LOGIN_USER);
        if (userDO == null) {
            return false;
        } else {
            return true;
        }
    }

    public static UserDO getCurrentUser(HttpSession session) {
        return (UserDO) session.getAttribute(GmxConstants.LOGIN_USER);
    }

}
