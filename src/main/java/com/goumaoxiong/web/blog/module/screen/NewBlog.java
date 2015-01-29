package com.goumaoxiong.web.blog.module.screen;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.goumaoxiong.common.GmxConstants;
import com.goumaoxiong.common.SessionUtil;
import com.goumaoxiong.dal.object.UserDO;

public class NewBlog {

    public void execute(HttpServletRequest request, Navigator nav, Context context) {
        if (!SessionUtil.isLogin(request.getSession())) {
            nav.redirectTo("login");
            return;
        }
        UserDO user = (UserDO) request.getSession().getAttribute(GmxConstants.LOGIN_USER);
        context.put("user", user);
    }

}
