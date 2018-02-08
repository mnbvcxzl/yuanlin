package com.yuanlin.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuanlin.o2o.entity.HotSpot;

public interface HeadDao {
	/**
	 * 根据传入的查询条件(头条名查询头条)
	 * 
	 * @return
	 */
	List<HotSpot> queryHeadLine(@Param("headLineCondition") HotSpot headLineCondition);
}
