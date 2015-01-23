package com.goumaoxiong.web.blog.module.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.citrus.turbine.Navigator;
import com.goumaoxiong.dal.object.FloorDO;
import com.goumaoxiong.service.FloorService;

public class BlogAction {

    @Resource(name = "floorService")
    private FloorService floorService;

    public void doNewBlog(HttpServletRequest request, Navigator nav) {
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
        FloorDO floorDO = new FloorDO();
        floorDO.setSubject(subject);
        floorDO.setContent(content);
        floorDO.setUserName("狗猫熊");
        floorService.addNewFloor(floorDO);
        nav.redirectTo("myBlog");
    }

}
