package com.goumaoxiong.dal.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.goumaoxiong.dal.dao.DongbaoDAO;
import com.goumaoxiong.dal.object.DongbaoDo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class DongbaoDAOImpl implements DongbaoDAO {

	@Resource(name = "sqlMapClient")
	private SqlMapClient sqlMapClient;

	@Override
	public Long addNew(DongbaoDo dongbaoDo) {
		try {
			return (Long) sqlMapClient.insert("ADD_NEW", dongbaoDo);
		} catch (SQLException e) {
			e.printStackTrace();
			return -1L;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DongbaoDo> queryAll() {
		List<DongbaoDo> dongbaoDos = new ArrayList<DongbaoDo>();
		try {
			dongbaoDos = sqlMapClient.queryForList("QUERY_ALL");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dongbaoDos;
	}

}
