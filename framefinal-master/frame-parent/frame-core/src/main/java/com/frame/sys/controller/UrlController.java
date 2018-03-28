package com.frame.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UrlController {

	@RequestMapping({"/main","/"}) 
	public String index() {
		return "main";
	}
}
