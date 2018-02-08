package com.yuanlin.o2o.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yuanlin.o2o.BaseTest;
import com.yuanlin.o2o.dto.WechatExe;
import com.yuanlin.o2o.entity.UserInfo;
import com.yuanlin.o2o.entity.Wechat;
import com.yuanlin.o2o.exceptions.WechatAuthStateEnum;

public class WechatServiceTest extends BaseTest {
	@Autowired
	private WechatService wechatService;

	@Test
	public void testRegister() {
		// 新增一条微信帐号
		Wechat wechatAuth = new Wechat();
		UserInfo personInfo = new UserInfo();
		String openId = "mnbvcxzl";
		// 给微信帐号设置上用户信息，但不设置上用户Id
		// 希望创建微信帐号的时候自动创建用户信息
		personInfo.setCreateTime(new Date());
		personInfo.setUserName("平儿");
		personInfo.setUserType(1);
		wechatAuth.setUserInfo(personInfo);
		wechatAuth.setOpenId(openId);
		wechatAuth.setCreateTime(new Date());
		WechatExe wae = wechatService.register(wechatAuth);
		assertEquals(WechatAuthStateEnum.SUCCESS.getState(), wae.getState());
		// 通过openId找到新增的wechatAuth
		wechatAuth = wechatService.getWechatAuthByOpenId(openId);
		// 打印用户名字看看跟预期是否相符
		System.out.println(wechatAuth.getUserInfo().getUserName());
	}
}
