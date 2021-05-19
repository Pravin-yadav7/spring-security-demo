package com.divergentsl.springbootsecurity.dao;

import java.util.List;

public interface BaseDao<T> {
	
	public void insert(T t);

	public T find(int id);

	public List<T> findAll();

	public void remove(int id);


}
