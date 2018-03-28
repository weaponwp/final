package com.frame.sys.mapper;

import com.frame.base.mapper.BaseMapper;
import com.frame.mybatis.MyBatisMapper;
import com.frame.sys.entity.User;

@MyBatisMapper
public interface UserMapper extends BaseMapper<User> {
	
	User queryByLoginId(String loginId);
}
