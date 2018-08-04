package com.ggc.ms.service;

import java.util.List;

import com.ggc.ms.pojo.PaginationVO;
import com.ggc.ms.pojo.ResourcePO;

public interface IResourceService {
	/**
	 * 保存playmovie
	 * @param playMoviePO
	 */
	void add(ResourcePO resourcePO);
	
	/**
	 * 批量保存playmovie
	 * @param playMoviePO
	 */
	void batchAdd(List<ResourcePO> resourcePOs);
	
	/**
	 * 根据id删除playmovie
	 * @param id
	 */
	void removeById(String id);
	
	/**
	 * 根据id批量删除playmovie
	 * @param id
	 */
	void batchRemoveById(List<String> ids);
	
	/**
	 * 根据id获取playmovie对象
	 * @param id
	 * @return
	 */
	ResourcePO getById(String id);
	
	/**
	 * 修改PlayMoviePO
	 * @param playMoviePO
	 */
	void modify(ResourcePO resourcePO);
	
	/**
	 * 获取所有ResourcePO，一般不会用此方式
	 * @return
	 */
	List<ResourcePO> getAll();

	/**
	 * 根据type获取所有PlayMoviePO对象，一般不会用此方式
	 * @param type
	 * @return
	 */
	List<ResourcePO> getByType(String type);

	/**
	 * 根据info获取List<ResourcePO>
	 * @param info
	 * @return
	 */
	List<ResourcePO> getByInfo(String info);
	
	/**
	 * 根据条件和页数据获取当前页数据，一般用此方法，使用resourcePO类做条件类（简化）
	 * @return
	 */
	PaginationVO<ResourcePO> getByCondetionPage(ResourcePO condetion);
	
	/**
	 * 获取推荐影片、资源 2017-1-27添加字段及相关方法
	 * @param info
	 * @return
	 */
	PaginationVO<ResourcePO> getSpecial(ResourcePO resourcePO);

	
	
}
