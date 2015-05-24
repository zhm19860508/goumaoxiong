package com.goumaoxiong.dal.dao;

import java.util.List;

import com.goumaoxiong.dal.object.DongbaoDo;

public interface DongbaoDAO {

	public Long addNew(DongbaoDo dongbaoDo);

	public List<DongbaoDo> queryAll();

}
