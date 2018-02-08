package com.yuanlin.o2o.service;

import com.yuanlin.o2o.dto.LocalAuthExecution;
import com.yuanlin.o2o.entity.LocalAccount;
import com.yuanlin.o2o.exceptions.LocalAuthOperationException;

public interface LocalAuthService {
	/**
	 * 通过帐号和密码获取平台帐号信息
	 * 
	 * @param userName
	 * @return
	 */
	LocalAccount getLocalAuthByUsernameAndPwd(String userName, String password);

	/**
	 * 通过userId获取平台帐号信息
	 * 
	 * @param userId
	 * @return
	 */
	LocalAccount getLocalAuthByUserId(long userId);

	/**
	 * 绑定微信，生成平台专属的帐号
	 * 
	 * @param localAuth
	 * @return
	 * @throws RuntimeException
	 */
	LocalAuthExecution bindLocalAuth(LocalAccount localAuth) throws LocalAuthOperationException;

	/**
	 * 修改平台帐号的登录密码
	 * 
	 * @param localAuthId
	 * @param userName
	 * @param password
	 * @param newPassword
	 * @param lastEditTime
	 * @return
	 */
	LocalAuthExecution modifyLocalAuth(Long userId, String username, String password, String newPassword)
			throws LocalAuthOperationException;
}
