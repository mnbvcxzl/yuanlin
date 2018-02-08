package com.yuanlin.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yuanlin.o2o.BaseTest;
import com.yuanlin.o2o.entity.Area;
import com.yuanlin.o2o.entity.Shop;
import com.yuanlin.o2o.entity.ShopCategory;
import com.yuanlin.o2o.entity.UserInfo;

public class ShopDaoTest extends BaseTest{
	@Autowired
	private ShopDao shopDao;
	@Test
	@Ignore
	public void testQueryByShopId() {
		long shopId = 1;
		Shop shop = shopDao.queryByShopId(shopId);
		System.out.println("areaId:" + shop.getArea().getAreaId());
		System.out.println("areaName" + shop.getArea().getAreaName());
	}
	@Test
	public void testInsertShop() {
		Shop shop = new Shop();
		UserInfo owner = new UserInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(2);
		shopCategory.setShopCategoryId(1L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("元琳的店铺");
		shop.setShopDesc("品质有保证，价格更优惠");
		shop.setShopAddr("山东省烟台市");
		shop.setPhone("17862819195");
		shop.setShopImg("test");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(0);
		shop.setAdvice("审核中");
		int returnNum = shopDao.insertShop(shop);
		assertEquals(1, returnNum);
	}
	@Test
	@Ignore
	public void testUpdateShop() {
		Shop shop = new Shop();
		shop.setShopId(1L);
		shop.setShopDesc("描述");
		shop.setLastEditTime(new Date());
		int returnNum = shopDao.updateShop(shop);
		assertEquals(1, returnNum);
	}
	@Test
	@Ignore
	public void testQueryShopListAndCount() {
//		Shop shopCondition = new Shop();
//		UserInfo owner = new UserInfo();
//		owner.setUserId(1L);
//		shopCondition.setOwner(owner);
//		List<Shop> shopList=shopDao.queryShopList(shopCondition, 0, 5);
//		int count = shopDao.queryShopCount(shopCondition);
//		System.out.println("店铺列表的条数"+shopList.size());
//		System.out.println("店铺总数"+count);
//		ShopCategory sc=new ShopCategory();
//		sc.setShopCategoryId(1L);
//		shopCondition.setShopCategory(sc);
//		shopList=shopDao.queryShopList(shopCondition, 0, 3);
//		count=shopDao.queryShopCount(shopCondition);
//		System.out.println("种类店铺列表的条数"+shopList.size());
//		System.out.println("种类店铺总数"+count);
		Shop shopCondition = new Shop();
		ShopCategory childCategory = new ShopCategory();
		ShopCategory parentCategory = new ShopCategory();
		parentCategory.setShopCategoryId(1L);
		childCategory.setParent(parentCategory);
		shopCondition.setShopCategory(childCategory);
		List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 6);
		int count = shopDao.queryShopCount(shopCondition);
		System.out.println("店铺列表的大小：" + shopList.size());
		System.out.println("店铺总数：" + count);
	}
}
