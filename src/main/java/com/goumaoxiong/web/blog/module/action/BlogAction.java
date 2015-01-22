package com.goumaoxiong.web.blog.module.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.goumaoxiong.dal.object.FloorDO;
import com.goumaoxiong.service.FloorService;

public class BlogAction {

    @Resource(name = "floorService")
    private FloorService floorService;

    public void doNewBlog(HttpServletRequest request) {
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
        FloorDO floorDO = new FloorDO();
        floorDO.setSubject(subject);
        floorDO.setContent(content);
        floorDO.setUserName("狗猫熊");
        floorService.addNewFloor(floorDO);
    }

}
