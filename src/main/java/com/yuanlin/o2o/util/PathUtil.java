package com.yuanlin.o2o.util;



public class PathUtil {
	private static String separator = System.getProperty("file.separator");
	/**
	 * 根路径
	 * @return
	 */
	public static String getImgBasePath() {
		String os=System.getProperty("os.name");
		String basePath="";
		if(os.toLowerCase().startsWith("win")) {
			basePath="D:/temp/image";
		}else {
			basePath="/Users/baidu/work/image";
		}
		basePath = basePath.replace("/", separator);
		return basePath;
	}
	/**
	 * 相对值路径
	 * @param shopId
	 * @return
	 */
	public static String getShopImagePath(long shopId) {
		String imagePath="/upload/item/shop/"+shopId+"/";
		return imagePath.replace("/", separator);
	}
	
}
