package com.frame.base.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.frame.base.mapper.BaseMapper;
import com.frame.base.service.BaseService;

public abstract class BaseServiceImpl<T, M extends BaseMapper<T>> implements BaseService<T> {

	@Autowired
	protected M mapper;
	
	public boolean add(T t) {
		mapper.add(t);
		return Boolean.TRUE;
	}

	public boolean del(int id) {
		mapper.del(id);
		return Boolean.TRUE;
	}

	public boolean update(T t) {
		mapper.update(t);
		return Boolean.TRUE;
	}

	public boolean update(int id, boolean delFlag) {
		mapper.updateDelFlag(id, delFlag);
		return Boolean.TRUE;
	}

	public T queryById(int id) {
		return mapper.queryById(id);
	}

	public List<T> queryList() {
		return mapper.queryList();
	}

	public List<T> queryList(boolean delFlag) {
		return mapper.queryListByDelFlag(delFlag);
	}

}
