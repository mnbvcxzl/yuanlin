package com.yuanlin.o2o.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yuanlin.o2o.BaseTest;
import com.yuanlin.o2o.entity.ShopCategory;

public class ShopCategoryDaoTest extends BaseTest {
	@Autowired
	private ShopCategoryDao shopCategoryDao;

	@Test
	public void testQueryShopCategory() {
//		List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(new ShopCategory());
//		assertEquals(3, shopCategoryList.size());
//		ShopCategory shopCategory = new ShopCategory();
//		ShopCategory parentCategory = new ShopCategory();
//		parentCategory.setShopCategoryId(1L);
//		shopCategory.setParent(parentCategory);
//		shopCategoryList = shopCategoryDao.queryShopCategory(shopCategory);
//		assertEquals(1, shopCategoryList.size());
//		System.out.println(shopCategoryList.get(0).getShopCategoryName());
		List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(null);
		System.out.println(shopCategoryList.size());
	}
}
