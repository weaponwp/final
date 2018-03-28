package com.frame.sys.service.impl;

import org.springframework.stereotype.Service;
import com.frame.base.service.impl.BaseServiceImpl;
import com.frame.sys.entity.User;
import com.frame.sys.mapper.UserMapper;
import com.frame.sys.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserMapper> implements UserService {

	public User queryByLoginId(String loginId) {
		log.info("UserServiceImpl queryByLoginId loginId : "+loginId);
		return mapper.queryByLoginId(loginId);
	}

}
