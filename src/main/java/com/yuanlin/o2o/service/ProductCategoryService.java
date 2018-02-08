package com.yuanlin.o2o.service;

import java.util.List;

import com.yuanlin.o2o.dto.ProductCategoryExe;
import com.yuanlin.o2o.entity.ProductCategory;
import com.yuanlin.o2o.exceptions.ProductCategoryOperationException;

public interface ProductCategoryService {
	/**
	 * 查询指定某个店铺下的所有商品类别信息
	 * 
	 * @param long
	 *            shopId
	 * @return List<ProductCategory>
	 */
	List<ProductCategory> getProductCategoryList(long shopId);
	/**
	 * 
	 * @param productCategory
	 * @return
	 * @throws ProductCategoryOperationException
	 */
	ProductCategoryExe batchAddProductCategory(List<ProductCategory> productCategoryList)
			throws ProductCategoryOperationException;
	/**
	 * 将此类别下的商品里的类别id置为空，再删除掉该商品类别
	 * @param productCategoryId
	 * @param shopId
	 * @return
	 * @throws RuntimeException
	 */
	ProductCategoryExe deleteProductCategory(long productCategoryId, long shopId)
			throws ProductCategoryOperationException;	
}
