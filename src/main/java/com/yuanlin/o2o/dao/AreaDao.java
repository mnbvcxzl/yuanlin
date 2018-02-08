package com.yuanlin.o2o.dao;

import java.util.List;

import com.yuanlin.o2o.entity.Area;

public interface AreaDao {
	/**
	 * 列出区域列表
	 * 
	 * @return areaList
	 */
	List<Area> queryArea();
}
