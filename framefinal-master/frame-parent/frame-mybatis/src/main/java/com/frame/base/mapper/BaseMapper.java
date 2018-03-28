package com.frame.base.mapper;

import java.util.List;

public interface BaseMapper<T> {

	void add(T t);
	
	void del(int id);
	
	void update(T t);
	
	void updateDelFlag(int id, boolean delFlag);
	
	T queryById(int id);
	
	List<T> queryList();
	
	List<T> queryListByDelFlag(boolean delFlag);
}
