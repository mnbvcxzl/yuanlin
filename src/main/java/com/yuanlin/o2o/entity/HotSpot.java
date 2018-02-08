package com.yuanlin.o2o.entity;

import java.util.Date;

public class HotSpot {
	// 主键ID
	private Long hotSpotId;
	// 热点名字
	private String hotSpotName;
	// 热点链接，点击头条会进入相应链接中
	private String hotSpotLink;
	// 热点图片
	private String hotSpotImg;
	// 权重，越大越排前显示
	private Integer priority;
	// 0.不可用 1.可用
	private Integer enableStatus;
	// 创建时间
	private Date createTime;
	// 最近一次的更新时间
	private Date lastEditTime;
	public Long getHotSpotId() {
		return hotSpotId;
	}
	public void setHotSpotId(Long hotSpotId) {
		this.hotSpotId = hotSpotId;
	}
	public String getHotSpotName() {
		return hotSpotName;
	}
	public void setHotSpotName(String hotSpotName) {
		this.hotSpotName = hotSpotName;
	}
	public String getHotSpotLink() {
		return hotSpotLink;
	}
	public void setHotSpotLink(String hotSpotLink) {
		this.hotSpotLink = hotSpotLink;
	}
	public String getHotSpotImg() {
		return hotSpotImg;
	}
	public void setHotSpotImg(String hotSpotImg) {
		this.hotSpotImg = hotSpotImg;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Integer getEnableStatus() {
		return enableStatus;
	}
	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
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
	
}
