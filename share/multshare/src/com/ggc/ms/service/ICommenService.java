package com.ggc.ms.service;

import com.ggc.ms.pojo.CommenPO;
import com.ggc.ms.pojo.ResourcePO;

public interface ICommenService {
	/**
	 * 保存playmovie
	 * @param playMoviePO
	 */
	void add(CommenPO commenPO);
	
	
	/**
	 * 根据id删除playmovie
	 * @param id
	 */
	void removeById(String id);
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
