package com.frame.sys.service;

import com.frame.base.service.BaseService;
import com.frame.sys.entity.User;

public interface UserService extends BaseService<User> {

	User queryByLoginId(String loginId);
}
