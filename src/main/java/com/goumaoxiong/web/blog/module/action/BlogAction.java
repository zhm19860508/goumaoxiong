package com.goumaoxiong.web.blog.module.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.alibaba.citrus.turbine.Navigator;
import com.goumaoxiong.common.SessionUtil;
import com.goumaoxiong.dal.object.FloorDO;
import com.goumaoxiong.dal.object.UserDO;
import com.goumaoxiong.service.FloorService;

public class BlogAction {

    private static String DEFAULT_NICK = "狗猫熊";

    @Resource(name = "floorService")
    private FloorService  floorService;

    public void doNewBlog(HttpServletRequest request, Navigator nav) {
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
        FloorDO floorDO = new FloorDO();
        if (StringUtils.isNotBlank(subject) && StringUtils.isNotBlank(content)) {
            floorDO.setSubject(subject);
            floorDO.setContent(content);
        }
        UserDO user = SessionUtil.getCurrentUser(request.getSession());
        if (user != null) {
            floorDO.setUserName(user.getNick());
        } else {
            floorDO.setUserName(DEFAULT_NICK);
        }
        floorService.addNewFloor(floorDO);
        nav.redirectTo("myBlog");
    }

}
