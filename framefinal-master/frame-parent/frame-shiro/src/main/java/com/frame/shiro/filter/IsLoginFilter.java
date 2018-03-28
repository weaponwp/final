package com.frame.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import com.frame.shiro.util.ShiroUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IsLoginFilter extends AccessControlFilter {

	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		if(ShiroUtil.isLogin()) {
			log.info("islogin");
			return Boolean.FALSE;
		}
		log.info("not login");
		return Boolean.TRUE;
	}

	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		String fallbackUrl = (String) getSubject(request, response).getSession().getAttribute("authc.fallbackUrl");
		if (StringUtils.isEmpty(fallbackUrl)) {
			fallbackUrl = "/";
		}
		log.info("IsLoginFilter fallbackUrl : " + fallbackUrl);
		WebUtils.redirectToSavedRequest(request, response, fallbackUrl);
		return false;
	}

}
