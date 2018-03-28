package com.frame.sys.test;

import java.util.Collection;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.frame.shiro.pwd.PwdEncrypt;
import com.frame.sys.entity.User;
import com.frame.sys.service.UserService;

@RestController
public class TestController {

	@Autowired
	private UserService userService;
	@Autowired
	private PwdEncrypt pwdEncrypt;
	@Autowired 
	private SessionDAO sessionDao;
	
	@GetMapping("/adduser")
	public boolean addUser() {
		User user = new User();
		user.setLoginId("a1");
		user.setPassword("123");
		pwdEncrypt.encryptPassword(user);
		userService.add(user);
		return Boolean.TRUE;
	}
	
	@GetMapping("/ss")
	public void list() {
		System.out.println("list");
		Collection<Session> list = sessionDao.getActiveSessions();
		System.out.println(list!=null?list.size():0);
		list.forEach(s-> System.out.println(s.getId().toString()));
	}
}
