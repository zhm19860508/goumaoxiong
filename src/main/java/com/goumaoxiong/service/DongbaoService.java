package com.goumaoxiong.service;

import java.util.List;

import com.goumaoxiong.dal.object.DongbaoDo;

public interface DongbaoService {

	public Long addNew(DongbaoDo dongbaoDo);

	public List<DongbaoDo> queryAll();
}
