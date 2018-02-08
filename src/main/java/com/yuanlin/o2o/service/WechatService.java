package com.yuanlin.o2o.service;

import com.yuanlin.o2o.dto.WechatExe;
import com.yuanlin.o2o.entity.Wechat;
import com.yuanlin.o2o.exceptions.WechatOperationException;

public interface WechatService {
	/**
	 * 通过openId查找平台对应的微信帐号
	 * 
	 * @param openId
	 * @return
	 */
	Wechat getWechatAuthByOpenId(String openId);

	/**
	 * 注册本平台的微信帐号
	 * 
	 * @param wechatAuth
	 * @param profileImg
	 * @return
	 * @throws RuntimeException
	 */
	WechatExe register(Wechat wechatAuth) throws WechatOperationException;
}
