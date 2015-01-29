package com.goumaoxiong.web.home.module.screen;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.citrus.turbine.Navigator;
import com.goumaoxiong.common.GmxConstants;

public class Logout {

    public void execute(HttpServletRequest request, Navigator navigator) {
        // 删除session中的用户信息
        HttpSession session = request.getSession();
        session.removeAttribute(GmxConstants.LOGIN_USER);

        // 跳转
        navigator.redirectTo("index");

    }

}
