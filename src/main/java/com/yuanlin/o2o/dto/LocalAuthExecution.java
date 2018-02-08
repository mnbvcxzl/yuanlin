package com.yuanlin.o2o.dto;

import java.util.List;

import com.yuanlin.o2o.entity.LocalAccount;
import com.yuanlin.o2o.enums.LocalAuthStateEnum;

public class LocalAuthExecution {
	// 结果状态
		private int state;

		// 状态标识
		private String stateInfo;

		private int count;

		private LocalAccount localAuth;

		private List<LocalAccount> localAuthList;

		public LocalAuthExecution() {
		}

		// 失败的构造器
		public LocalAuthExecution(LocalAuthStateEnum stateEnum) {
			this.state = stateEnum.getState();
			this.stateInfo = stateEnum.getStateInfo();
		}

		// 成功的构造器
		public LocalAuthExecution(LocalAuthStateEnum stateEnum, LocalAccount localAuth) {
			this.state = stateEnum.getState();
			this.stateInfo = stateEnum.getStateInfo();
			this.localAuth = localAuth;
		}

		// 成功的构造器
		public LocalAuthExecution(LocalAuthStateEnum stateEnum,
				List<LocalAccount> localAuthList) {
			this.state = stateEnum.getState();
			this.stateInfo = stateEnum.getStateInfo();
			this.localAuthList = localAuthList;
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

		public LocalAccount getLocalAuth() {
			return localAuth;
		}

		public void setLocalAuth(LocalAccount localAuth) {
			this.localAuth = localAuth;
		}

		public List<LocalAccount> getLocalAuthList() {
			return localAuthList;
		}

		public void setLocalAuthList(List<LocalAccount> localAuthList) {
			this.localAuthList = localAuthList;
		}
}
