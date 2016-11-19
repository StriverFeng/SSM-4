package com.silence.ssm.mapper;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T, ID extends Serializable> {

	/**
	 * 插入记录
	 * 
	 * @param object
	 * @return
	 */
	int insert(Map<String, Object> params);

	/**
	 * 插入记录
	 * 
	 * @param object
	 * @return
	 * 
	 */
	int insert(T object);

	/**
	 * 批量插入
	 * 
	 * @param list
	 * @return
	 */
	int batchInsert(List<T> list);

	/**
	 * 查询记录
	 * 
	 * @param object
	 * @return
	 */
	T findById(Long ID);

	/**
	 * 根据条件查询列表
	 * 
	 * @param params
	 * @return
	 */
	List<T> list(Map<String, Object> params);

	/**
	 * 根据ID删除某一条记录
	 * 
	 * @param id
	 * @return
	 */
	int deleteById(Long ID);

	/**
	 * 根据参数删除某一条记录
	 * 
	 * @param params
	 * @return
	 */
	int deleteById(Map<String, Object> params);

	/**
	 * 批量删除
	 * 
	 * @param list
	 * @return
	 */
	int batchDelete(List<String> list);

	/**
	 * 更新对象
	 * 
	 * @param object
	 * @return
	 */
	int update(Map<String, Object> params);

	/**
	 * 更新对象
	 * 
	 * @param object
	 * @return
	 */
	int update(T object);

	/**
	 * 批量更新
	 * 
	 * @param list
	 * @return
	 */
	int batchUpdate(List<T> list);

	/**
	 * 根据条件查询总数
	 * 
	 * @param params
	 * @return
	 */
	int count(Map<String, Object> params);

}