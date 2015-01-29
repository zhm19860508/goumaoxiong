package com.goumaoxiong.web.home.module.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.goumaoxiong.common.GmxConstants;
import com.goumaoxiong.dal.object.UserDO;
import com.goumaoxiong.service.UserService;

public class LoginAction {

    @Resource(name = "userService")
    private UserService userService;

    public void doLogin(HttpServletRequest request, HttpSession session, Navigator nav, Context context) {
        String userName = request.getParameter("user_name");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("remember_me");
        String callback = request.getParameter("callback");
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
            nav.redirectTo("login").withParameter("result", "false");
            return;
        }
        UserDO userDO = userService.queryUserByUserName(userName);
        if (userDO == null || !userDO.getPassword().equals(sec(password))) {
            nav.redirectTo("login").withParameter("result", "false");
            return;
        } else {
            session.setAttribute(GmxConstants.LOGIN_USER, userDO);
            if (!"on".equals(rememberMe)) {
                session.setMaxInactiveInterval(3600);
            }
            nav.redirectToLocation(callback);
            return;
        }
    }

    private String sec(String inStr) {
        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;
    }

}
