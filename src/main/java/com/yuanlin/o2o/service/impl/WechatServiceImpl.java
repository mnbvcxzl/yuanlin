package com.yuanlin.o2o.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuanlin.o2o.dao.PersonInfoDao;
import com.yuanlin.o2o.dao.WechatDao;
import com.yuanlin.o2o.dto.WechatExe;
import com.yuanlin.o2o.entity.UserInfo;
import com.yuanlin.o2o.entity.Wechat;
import com.yuanlin.o2o.exceptions.WechatAuthStateEnum;
import com.yuanlin.o2o.exceptions.WechatOperationException;
import com.yuanlin.o2o.service.WechatService;
@Service
public class WechatServiceImpl implements WechatService {
	private static Logger log = LoggerFactory.getLogger(WechatServiceImpl.class);
	@Autowired
	private WechatDao wechatAuthDao;
	@Autowired
	private PersonInfoDao personInfoDao;

	@Override
	public Wechat getWechatAuthByOpenId(String openId) {
		return wechatAuthDao.queryWechatInfoByOpenId(openId);
	}

	@Override
	@Transactional
	public WechatExe register(Wechat wechatAuth) throws WechatOperationException {
		//空值判断
		if (wechatAuth == null || wechatAuth.getOpenId() == null) {
			return new WechatExe(WechatAuthStateEnum.NULL_AUTH_INFO);
		}
		try {
			//设置创建时间
			wechatAuth.setCreateTime(new Date());
			//如果微信帐号里夹带着用户信息并且用户Id为空，则认为该用户第一次使用平台(且通过微信登录)
			//则自动创建用户信息
			if (wechatAuth.getUserInfo() != null && wechatAuth.getUserInfo().getUserId() == null) {
				try {					
					wechatAuth.getUserInfo().setCreateTime(new Date());
					wechatAuth.getUserInfo().setEnableStatus(1);
					UserInfo personInfo = wechatAuth.getUserInfo();
					int effectedNum = personInfoDao.insertPersonInfo(personInfo);
					wechatAuth.setUserInfo(personInfo);
					if (effectedNum <= 0) {
						throw new WechatOperationException("添加用户信息失败");
					}
				} catch (Exception e) {
					log.error("insertPersonInfo error:" + e.toString());
					throw new WechatOperationException("insertPersonInfo error: " + e.getMessage());
				}
			}
			//创建专属于本平台的微信帐号
			int effectedNum = wechatAuthDao.insertWechatAuth(wechatAuth);
			if (effectedNum <= 0) {
				throw new WechatOperationException("帐号创建失败");
			} else {
				return new WechatExe(WechatAuthStateEnum.SUCCESS, wechatAuth);
			}
		} catch (Exception e) {
			log.error("insertWechatAuth error:" + e.toString());
			throw new WechatOperationException("insertWechatAuth error: " + e.getMessage());
		}
	}
}
