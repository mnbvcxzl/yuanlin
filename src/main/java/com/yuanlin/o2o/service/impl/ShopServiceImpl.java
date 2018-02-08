package com.yuanlin.o2o.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuanlin.o2o.dao.ShopDao;
import com.yuanlin.o2o.dto.Image;
import com.yuanlin.o2o.dto.ShopExe;
import com.yuanlin.o2o.entity.Shop;
import com.yuanlin.o2o.enums.ShopStateEnum;
import com.yuanlin.o2o.exceptions.ShopOperationException;
import com.yuanlin.o2o.service.ShopService;
import com.yuanlin.o2o.util.ImageUtil;
import com.yuanlin.o2o.util.Page;
import com.yuanlin.o2o.util.PathUtil;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDao shopDao;

	@Override
	@Transactional
	public ShopExe insertShop(Shop shop, Image thumbnail) {
		if (shop == null) {
			return new ShopExe(ShopStateEnum.NULL_SHOP);
		}
		try {
			// 给店铺信息赋初始值
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			// 添加店铺信息
			int effectedNum = shopDao.insertShop(shop);
			// throw new ShopOperationException("商铺创建失败");
			if (effectedNum <= 0) {
				throw new ShopOperationException("商铺创建失败");
			} else {
				if (thumbnail.getImage() != null) {
					try {
						addShopImg(shop, thumbnail);
					} catch (Exception e) {
						throw new ShopOperationException("addShopImg失败" + e.getMessage());
					}
					effectedNum = shopDao.updateShop(shop);
					if (effectedNum <= 0) {
						throw new ShopOperationException("update图片地址失败");
					}
				}
			}
		} catch (Exception e) {
			throw new ShopOperationException("insertShop error:" + e.getMessage());
		}
		return new ShopExe(ShopStateEnum.CHECK, shop);
	}

	private void addShopImg(Shop shop, Image thumbnail) {
		// 获取shop图片目录的相对值路径
		String dest = PathUtil.getShopImagePath(shop.getShopId());
		String shopImgAddr = ImageUtil.generateThumbnail(thumbnail, dest);
		shop.setShopImg(shopImgAddr);
	}

	@Override
	public Shop getByShopId(long shopId) {
		return shopDao.queryByShopId(shopId);
	}

	@Override
	public ShopExe modifyShop(Shop shop, Image thumbnail)
			throws ShopOperationException {
		if (shop == null || shop.getShopId() == null) {
			return new ShopExe(ShopStateEnum.NULL_SHOP);
		} else {
			// 判断是否修改图片
			try {
				if (thumbnail.getImage() != null && thumbnail.getImageName() != null && !"".equals(thumbnail.getImageName())) {
					Shop tempShop = shopDao.queryByShopId(shop.getShopId());
					if (tempShop.getShopImg() != null) {
						ImageUtil.deleteFileOrPath(tempShop.getShopImg());
					}
					addShopImg(shop, thumbnail);
				}
				// 更新店铺信息
				shop.setLastEditTime(new Date());
				int effectedNum = shopDao.updateShop(shop);
				if (effectedNum <= 0) {
					return new ShopExe(ShopStateEnum.INNER_ERROR);
				} else {
					shop = shopDao.queryByShopId(shop.getShopId());
					return new ShopExe(ShopStateEnum.SUCCESS, shop);
				}
			} catch (Exception e) {
				throw new ShopOperationException("rmodifyShop is error:" + e.getMessage());
			}
		}
	}

	@Override
	public ShopExe getShopList(Shop shopCondition, int pageIndex, int pageSize) {
		int rowIndex = Page.calculateRowIndex(pageIndex, pageSize);
		List<Shop> shopList=shopDao.queryShopList(shopCondition, rowIndex, pageSize);
		int count = shopDao.queryShopCount(shopCondition);
		ShopExe se=new ShopExe();
		if(shopList!=null) {
			se.setShopList(shopList);
			se.setCount(count);
		}else {
			se.setState(ShopStateEnum.INNER_ERROR.getState());
		}
		return se;
	}

}
