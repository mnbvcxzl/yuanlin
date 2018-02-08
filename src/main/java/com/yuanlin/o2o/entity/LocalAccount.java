package com.yuanlin.o2o.entity;

import java.util.Date;

public class LocalAccount {
	// 主键ID
	private Long localAccountId;
	// 帐号
	private String localAccountName;
	// 密码
	private String password;
	// 创建时间
	private Date createTime;
	// 最近一次的更新时间
	private Date lastEditTime;
	// 个人信息，关系为一一对应
	private UserInfo userInfo;

	public Long getLocalAccountId() {
		return localAccountId;
	}

	public void setLocalAccountId(Long localAccountId) {
		this.localAccountId = localAccountId;
	}

	public String getLocalAccountName() {
		return localAccountName;
	}

	public void setLocalAccountName(String localAccountName) {
		this.localAccountName = localAccountName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
