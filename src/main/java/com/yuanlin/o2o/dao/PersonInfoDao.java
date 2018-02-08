package com.yuanlin.o2o.dao;

import com.yuanlin.o2o.entity.UserInfo;

public interface PersonInfoDao {
	/**
	 * 通过用户Id查询用户
	 * 
	 * @param userId
	 * @return
	 */
	UserInfo queryPersonInfoById(long userId);

	/**
	 * 添加用户信息
	 * 
	 * @param personInfo
	 * @return
	 */
	int insertPersonInfo(UserInfo personInfo);
}
