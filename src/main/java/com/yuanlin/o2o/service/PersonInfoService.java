package com.yuanlin.o2o.service;

import com.yuanlin.o2o.entity.UserInfo;

public interface PersonInfoService {
	/**
	 * 根据用户Id获取personInfo信息
	 * @param userId
	 * @return
	 */
	UserInfo getPersonInfoById(Long userId);
}
