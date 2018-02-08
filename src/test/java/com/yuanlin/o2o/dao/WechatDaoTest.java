package com.yuanlin.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.yuanlin.o2o.BaseTest;
import com.yuanlin.o2o.entity.UserInfo;
import com.yuanlin.o2o.entity.Wechat;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WechatDaoTest extends BaseTest {
	@Autowired
	private WechatDao wechatAuthDao;

	@Test
	public void testAInsertWechatAuth() throws Exception {
		// 新增一条微信帐号
		Wechat wechatAuth = new Wechat();
		UserInfo personInfo = new UserInfo();
		personInfo.setUserId(2L);
		// 给微信帐号绑定上用户信息
		wechatAuth.setUserInfo(personInfo);
		// 随意设置上openId
		wechatAuth.setOpenId("dafahizhfdhaih");
		wechatAuth.setCreateTime(new Date());
		int effectedNum = wechatAuthDao.insertWechatAuth(wechatAuth);
		assertEquals(1, effectedNum);
	}

	@Test
	public void testBQueryWechatAuthByOpenId() throws Exception {
		Wechat wechatAuth = wechatAuthDao.queryWechatInfoByOpenId("dafahizhfdhaih");
		assertEquals("静书", wechatAuth.getUserInfo().getUserName());
	}
}
