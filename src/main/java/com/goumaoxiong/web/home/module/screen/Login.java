package com.goumaoxiong.web.home.module.screen;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.citrus.turbine.Context;

public class Login {

    public void execute(HttpServletRequest request, Context context) {
        if ("false".equals(request.getParameter("result"))) {
            context.put("msg", "你的用户名或者密码错啦~");
        }
    }

}
