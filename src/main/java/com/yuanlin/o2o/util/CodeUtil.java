package com.yuanlin.o2o.util;

import javax.servlet.http.HttpServletRequest;

public class CodeUtil {
	public static boolean checkVerifyCode(HttpServletRequest request) {
		String verifyCodeExpected = (String) request.getSession()
				.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		String verifyCode = HttpServletRequestUtil.getString(request, "verifyCode");
		if (verifyCode == null || !verifyCode.equals(verifyCodeExpected)) {
			return false;
		}
		return true;
	}
}
