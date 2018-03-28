package com.frame.base.service;

import java.util.List;

public interface BaseService<T> {

	boolean add(T t);

	boolean del(int id);

	boolean update(T t);

	boolean update(int id, boolean delFlag);

	T queryById(int id);

	List<T> queryList();

	List<T> queryList(boolean delFlag);
}