package com.yuanlin.o2o.service;

//import java.io.File;

import com.yuanlin.o2o.dto.Image;
import com.yuanlin.o2o.dto.ShopExe;
import com.yuanlin.o2o.entity.Shop;
import com.yuanlin.o2o.exceptions.ShopOperationException;

public interface ShopService {
	ShopExe insertShop(Shop shop,Image thumbnail);
	/**
	 * 通过店铺Id获取店铺信息
	 * 
	 * @param shopId
	 * @return
	 */
	Shop getByShopId(long shopId);
	ShopExe modifyShop(Shop shop,Image thumbnail) throws ShopOperationException;
	/**
	 * 根据shopCondition分页返回相应店铺列表
	 * 
	 * @param shopCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public ShopExe getShopList(Shop shopCondition, int pageIndex, int pageSize);
}
