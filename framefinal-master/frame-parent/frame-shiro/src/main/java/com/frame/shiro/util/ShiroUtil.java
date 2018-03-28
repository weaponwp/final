package com.frame.shiro.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public final class ShiroUtil {

	private ShiroUtil() {}
	
	public static boolean isLogin() {
		Subject subject = SecurityUtils.getSubject();
		if(subject.isAuthenticated()) {
			return true;
		}
		return false;
	}
}
