package com.yuanlin.o2o.service;

import java.util.List;

import com.yuanlin.o2o.entity.HotSpot;

public interface HeadService {
	public static final String HLLISTKEY="headlinelist";
	/**
	 * 根据传入的条件返回指定的头条列表
	 * 
	 * @param headLineCondition
	 * @return
	 * @throws IOException
	 */
	List<HotSpot> getHeadLineList(HotSpot headLineCondition);
}
