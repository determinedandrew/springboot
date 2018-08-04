package com.ggc.ms.dao;

import com.ggc.ms.pojo.CommenPO;
import com.ggc.ms.pojo.ResourcePO;


public interface ICommenDao {
	/**
	 * 保存资源
	 * @param resourcePO
	 */
	void insert(CommenPO commenPO);
	
	/**
	 * 根据id删除playmovie
	 * @param id
	 */
	void deleteById(String id);
	
	/**
	 * 根据id获取playmovie对象
	 * @param id
	 * @return
	 */
	CommenPO getByCcode(String ccode);
	
	/**
	 * 修改resourcePO
	 * @param resourcePO
	 */
	void update(CommenPO commenPO);
	
}
