package com.yuanlin.o2o.service;

import java.util.List;

import com.yuanlin.o2o.entity.ShopCategory;

public interface ShopCategoryService {
	public static final String SCLISTKEY = "shopcategorylist";
	List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
