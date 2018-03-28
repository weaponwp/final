package com.frame.sys.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.frame.shiro.util.ShiroUtil;

import lombok.extern.slf4j.Slf4j;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;

@Controller
@Slf4j
public class LoginController {
	
	@GetMapping("/login")
	public String login() {
		log.info("get login");
		return "login";
	}
	
	@PostMapping("/login")
    public String showLoginForm(HttpServletRequest req, Model model) {
		if(ShiroUtil.isLogin()) {return "main";}
        String exceptionClassName = (String)req.getAttribute("shiroLoginFailure");
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
        }
        model.addAttribute("error", error);
        return "login";
    }

}
