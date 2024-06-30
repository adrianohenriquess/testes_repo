package br.com.techbean.integation.dao;

import java.util.List;

public interface GenericDAO<T> {
	public boolean save(T entity);
	public boolean update(T entity);
	public boolean remove(T entity, Class<T> type, Integer id);
	public boolean remove(T entity, Class<T> type, Object  id);
	public T getById(Class<T> type, Integer id);
	public T getById(Class<T> type, Object  id);
	public List<T> findAll(Class<T> type);
}
