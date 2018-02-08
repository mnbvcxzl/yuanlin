package com.yuanlin.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yuanlin.o2o.BaseTest;
import com.yuanlin.o2o.dto.Image;
import com.yuanlin.o2o.dto.ShopExe;
import com.yuanlin.o2o.entity.Area;
import com.yuanlin.o2o.entity.Shop;
import com.yuanlin.o2o.entity.ShopCategory;
import com.yuanlin.o2o.entity.UserInfo;
import com.yuanlin.o2o.enums.ShopStateEnum;
import com.yuanlin.o2o.exceptions.ShopOperationException;

public class ShopServiceTest extends BaseTest {
	@Autowired
	private ShopService shopService;

	@Test
	public void testInsertShop() throws FileNotFoundException {
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
		shop.setShopName("数码宝贝");
		shop.setShopDesc("数码产品种类齐全，价格诱人");
		shop.setShopAddr("山东省猿淘市");
		shop.setPhone("123456");
		shop.setCreateTime(new Date());
		File shopImg=new File("C:\\Users\\Administrator\\Desktop\\bs\\bishe\\test.jpg");
		InputStream is = new FileInputStream(shopImg);
		Image image = new Image(shopImg.getName(),is);
		ShopExe se=shopService.insertShop(shop, image);
		assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
		
	}
	@Test
	@Ignore
	public void testModifyShop() throws ShopOperationException, FileNotFoundException {
		Shop shop = new Shop();
		shop.setShopId(1L);
		shop.setShopName("修改后的店铺名称");
		File shopImg = new File("C:\\Users\\Administrator\\Desktop\\bs\\bishe\\iphone.jpg");
		InputStream is = new FileInputStream(shopImg);
		Image image = new Image("iphone.jpg",is);
		ShopExe shopExecution = shopService.modifyShop(shop,image);
		System.out.println("新的图片地址为：" + shopExecution.getShop().getShopImg());
	}
	@Test
	@Ignore
	public void testGetShopList() {
//		Shop shopCondition = new Shop();
//		ShopCategory sc = new ShopCategory();
//		sc.setShopCategoryId(1L);
//		shopCondition.setShopCategory(sc);
//		ShopExe se = shopService.getShopList(shopCondition, 3, 2);
//		System.out.println("店铺列表数为：" + se.getShopList().size());
//		System.out.println("店铺总数为：" + se.getCount());
		Shop shopCondition = new Shop();
		ShopCategory childCategory = new ShopCategory();
		ShopCategory parentCategory = new ShopCategory();
		parentCategory.setShopCategoryId(1L);
		childCategory.setParent(parentCategory);
		shopCondition.setShopCategory(childCategory);
		ShopExe shopList=shopService.getShopList(shopCondition, 1, 3);
		System.out.println("店铺列表的大小：" + shopList.getShopList().size());
		System.out.println("店铺总数：" + shopList.getCount());
	}
}
