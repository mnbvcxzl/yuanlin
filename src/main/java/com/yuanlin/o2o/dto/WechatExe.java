package com.yuanlin.o2o.dto;

import java.util.List;

import com.yuanlin.o2o.entity.Wechat;
import com.yuanlin.o2o.exceptions.WechatAuthStateEnum;

public class WechatExe {
	// 结果状态
		private int state;

		// 状态标识
		private String stateInfo;

		private int count;

		private Wechat wechatAuth;

		private List<Wechat> wechatAuthList;

		public WechatExe() {
		}

		// 失败的构造器
		public WechatExe(WechatAuthStateEnum stateEnum) {
			this.state = stateEnum.getState();
			this.stateInfo = stateEnum.getStateInfo();
		}

		// 成功的构造器
		public WechatExe(WechatAuthStateEnum stateEnum, Wechat wechatAuth) {
			this.state = stateEnum.getState();
			this.stateInfo = stateEnum.getStateInfo();
			this.wechatAuth = wechatAuth;
		}

		// 成功的构造器
		public WechatExe(WechatAuthStateEnum stateEnum,
				List<Wechat> wechatAuthList) {
			this.state = stateEnum.getState();
			this.stateInfo = stateEnum.getStateInfo();
			this.wechatAuthList = wechatAuthList;
		}

		public int getState() {
			return state;
		}

		public void setState(int state) {
			this.state = state;
		}

		public String getStateInfo() {
			return stateInfo;
		}

		public void setStateInfo(String stateInfo) {
			this.stateInfo = stateInfo;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public Wechat getWechatAuth() {
			return wechatAuth;
		}

		public void setWechatAuth(Wechat wechatAuth) {
			this.wechatAuth = wechatAuth;
		}

		public List<Wechat> getWechatAuthList() {
			return wechatAuthList;
		}

		public void setWechatAuthList(List<Wechat> wechatAuthList) {
			this.wechatAuthList = wechatAuthList;
		}
}
