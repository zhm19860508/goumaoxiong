package com.goumaoxiong.web.story.module.screen;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import com.alibaba.citrus.turbine.Context;
import com.goumaoxiong.dal.object.DongbaoDo;
import com.goumaoxiong.service.DongbaoService;

public class DongbaoWedding {

	@Resource(name = "dongbaoService")
	private DongbaoService dongbaoService;

	public void execute(Context context) {
		List<DongbaoDo> dos = dongbaoService.queryAll();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		context.put("dos", dos);
		context.put("format", format);
	}

}
