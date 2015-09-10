package com.example.healthycare.dao;
import java.util.List;
/**
 * 
 * @author vominhtung
 *
 * @param <T>
 */
public interface BaseDao<T> {

	public List<T> findAll(Class<T> entityClass);

    public void insert(T t);

    public void remove(T t);

}
