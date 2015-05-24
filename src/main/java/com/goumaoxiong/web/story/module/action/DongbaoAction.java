package com.goumaoxiong.web.story.module.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.citrus.turbine.Navigator;
import com.goumaoxiong.dal.object.DongbaoDo;
import com.goumaoxiong.service.DongbaoService;

public class DongbaoAction {

	@Resource(name = "dongbaoService")
	private DongbaoService dongbaoService;

	public void doAddNew(HttpServletRequest request, Navigator nav) {
		String name = request.getParameter("name");
		String content = request.getParameter("content");

		DongbaoDo dongbaoDo = new DongbaoDo();
		dongbaoDo.setName(name);
		dongbaoDo.setContent(content);

		dongbaoService.addNew(dongbaoDo);

		nav.redirectTo("dongbaoWedding");
	}

}
