package com.yuanlin.o2o.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.yuanlin.o2o.entity.LocalAccount;

public interface LocalAuthDao {
	/**
	 * 通过帐号和密码查询对应信息，登录用
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	LocalAccount queryLocalByUserNameAndPwd(@Param("username") String username, @Param("password") String password);

	/**
	 * 通过用户Id查询对应localauth
	 * 
	 * @param userId
	 * @return
	 */
	LocalAccount queryLocalByUserId(@Param("userId") long userId);

	/**
	 * 添加平台帐号
	 * 
	 * @param localAuth
	 * @return
	 */
	int insertLocalAuth(LocalAccount localAuth);

	/**
	 * 通过userId,username,password更改密码
	 * 
	 * @param localAuth
	 * @return
	 */
	int updateLocalAuth(@Param("userId") Long userId, @Param("username") String username,
			@Param("password") String password, @Param("newPassword") String newPassword,
			@Param("lastEditTime") Date lastEditTime);
}
