package com.goumaoxiong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.goumaoxiong.dal.dao.DongbaoDAO;
import com.goumaoxiong.dal.object.DongbaoDo;
import com.goumaoxiong.service.DongbaoService;

public class DongbaoServiceImpl implements DongbaoService {

	@Resource(name = "dongbaoDAO")
	private DongbaoDAO dongbaoDAO;

	@Override
	public Long addNew(DongbaoDo dongbaoDo) {
		if (dongbaoDo == null) {
			return 0L;
		}
		return dongbaoDAO.addNew(dongbaoDo);
	}

	@Override
	public List<DongbaoDo> queryAll() {
		return dongbaoDAO.queryAll();
	}

}
