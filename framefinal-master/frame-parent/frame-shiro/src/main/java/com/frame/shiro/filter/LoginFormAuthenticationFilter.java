package com.frame.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginFormAuthenticationFilter extends FormAuthenticationFilter {

	protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
		log.info("LoginFormAuthenticationFilter issueSuccessRedirect");
		String fallbackUrl = (String) getSubject(request, response).getSession().getAttribute("authc.fallbackUrl");
		if (StringUtils.isEmpty(fallbackUrl)) {
			fallbackUrl = getSuccessUrl();
		}
		log.info("LoginFormAuthenticationFilter fallbackUrl : " + fallbackUrl);
		WebUtils.redirectToSavedRequest(request, response, fallbackUrl);
	}

	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		if (isLoginSubmission(request, response)) {
			log.info("isLoginSubmission");
			return Boolean.FALSE;
		}
		return super.isAccessAllowed(request, response, mappedValue);
	}
}