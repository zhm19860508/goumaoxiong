package com.goumaoxiong.web.blog.module.screen;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.alibaba.citrus.turbine.Context;
import com.goumaoxiong.dal.object.FloorDO;
import com.goumaoxiong.dal.query.FloorQuery;
import com.goumaoxiong.service.FloorService;

public class MyBlog {

    @Resource(name = "floorService")
    private FloorService   floorService;

    private static Integer DEFAULT_PAGE_SIZE = 10;

    public void execute(HttpServletRequest request, Context context) {

        String pageNumStr = request.getParameter("pageNum");
        String pageSizeStr = request.getParameter("pageSize");

        Integer pageNum = 0;
        if (StringUtils.isNumeric(pageNumStr)) {
            pageNum = Integer.parseInt(pageNumStr);
        }

        Integer pageSize = DEFAULT_PAGE_SIZE;
        if (StringUtils.isNumeric(pageNumStr)) {
            pageSize = Integer.parseInt(pageSizeStr);
        }

        FloorQuery query = new FloorQuery();
        query.setPageNum(pageNum);
        query.setPageSize(pageSize);

        List<FloorDO> floors = floorService.queryAllFloors(query);

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

        context.put("format", format);
        context.put("floors", floors);
    }
}
