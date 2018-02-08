package com.yuanlin.o2o.service;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.yuanlin.o2o.BaseTest;
import com.yuanlin.o2o.dto.LocalAuthExecution;
import com.yuanlin.o2o.entity.LocalAccount;
import com.yuanlin.o2o.entity.UserInfo;
import com.yuanlin.o2o.exceptions.WechatAuthStateEnum;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocalAuthServiceTest extends BaseTest {
	@Autowired
	private LocalAuthService localAuthService;

	@Test
	@Ignore
	public void testABindLocalAuth() {
		// 新增一条平台帐号
		LocalAccount localAuth = new LocalAccount();
		UserInfo personInfo = new UserInfo();
		String username = "抵达梦想";
		String password = "123456";
		// 给平台帐号设置上用户信息
		// 给用户设置上用户Id,标明是某个用户创建的帐号
		personInfo.setUserId(2L);
		// 给平台帐号设置用户信息,标明是与哪个用户绑定
		localAuth.setUserInfo(personInfo);
		// 设置帐号
		localAuth.setLocalAccountName(username);
		// 设置密码
		localAuth.setPassword(password);
		// 绑定帐号
		LocalAuthExecution lae = localAuthService.bindLocalAuth(localAuth);
		assertEquals(WechatAuthStateEnum.SUCCESS.getState(), lae.getState());
		// 通过userId找到新增的localAuth
		localAuth = localAuthService.getLocalAuthByUserId(personInfo.getUserId());
		// 打印用户名字和帐号密码看看跟预期是否相符
		System.out.println("用户昵称：" + localAuth.getUserInfo().getUserName());
		System.out.println("平台帐号密码：" + localAuth.getPassword());
	}

	@Test
	public void testBModifyLocalAuth() {
		// 设置帐号信息
		long userId = 2;
		String username = "抵达梦想";
		String password = "123456";
		String newPassword = "Yl960702.";
		// 修改该帐号对应的密码
		LocalAuthExecution lae = localAuthService.modifyLocalAuth(userId, username, password, newPassword);
		assertEquals(WechatAuthStateEnum.SUCCESS.getState(), lae.getState());
		// 通过帐号密码找到修改后的localAuth
		LocalAccount localAuth = localAuthService.getLocalAuthByUsernameAndPwd(username, newPassword);
		// 打印用户名字看看跟预期是否相符
		System.out.println(localAuth.getUserInfo().getUserName());
	}
}
