package com.yuanlin.o2o.entity;

import java.util.Date;

public class Wechat {
	// 主键ID
	private Long wechatId;
	// 微信获取用户信息的凭证，对于某个公众号具有唯一性
	private String openId;
	// 创建时间
	private Date createTime;
	// 用户信息
	private UserInfo userInfo;
	public Long getWechatId() {
		return wechatId;
	}
	public void setWechatId(Long wechatId) {
		this.wechatId = wechatId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
}
