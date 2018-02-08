package com.yuanlin.o2o.service;

import java.util.List;

import com.yuanlin.o2o.dto.Image;
import com.yuanlin.o2o.dto.ProductExe;
import com.yuanlin.o2o.entity.Product;
import com.yuanlin.o2o.exceptions.ProductOperationException;

public interface ProductService {
	/**
	 * 查询商品列表并分页，可输入的条件有： 商品名（模糊），商品状态，店铺Id,商品类别
	 * 
	 * @param productCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	ProductExe getProductList(Product productCondition, int pageIndex, int pageSize);
	/**
	 * 添加商品信息以及图片处理
	 * 
	 * @param product
	 * @param thumbnail
	 * @param productImgs
	 * @return
	 * @throws ProductOperationException
	 */
	ProductExe addProduct(Product product,Image thumbnail,List<Image> productImgList) throws ProductOperationException;
	/**
	 * 通过商品Id查询唯一的商品信息
	 * 
	 * @param productId
	 * @return
	 */
	Product getProductById(long productId);
	/**
	 * 修改商品信息以及图片处理
	 * 
	 * @param product
	 * @param thumbnail
	 * @param productImgs
	 * @return
	 * @throws ProductOperationException
	 */
	ProductExe modifyProduct(Product product, Image thumbnail, List<Image> productImgHolderList)
			throws ProductOperationException;
}
