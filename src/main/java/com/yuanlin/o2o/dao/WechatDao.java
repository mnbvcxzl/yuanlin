package com.yuanlin.o2o.dao;

import com.yuanlin.o2o.entity.Wechat;

public interface WechatDao {
	/**
	 * 通过openId查询对应本平台的微信帐号
	 * 
	 * @param openId
	 * @return
	 */
	Wechat queryWechatInfoByOpenId(String openId);

	/**
	 * 添加对应本平台的微信帐号
	 * 
	 * @param wechatAuth
	 * @return
	 */
	int insertWechatAuth(Wechat wechatAuth);
}
