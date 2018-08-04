package com.ggc.ms.dao;

import java.util.List;

import com.ggc.ms.pojo.ResourcePO;


public interface IResourceDao {
	/**
	 * 保存资源
	 * @param resourcePO
	 */
	void insert(ResourcePO resourcePO);
	
	/**
	 * 批量保存playmovie
	 * @param resourcePO
	 */
	void batchInsert(List<ResourcePO> resourcePOs);
	
	/**
	 * 根据id删除playmovie
	 * @param id
	 */
	void deleteById(String id);
	
	/**
	 * 根据id批量删除playmovie
	 * @param id
	 */
	void batchDeleteById(List<String> ids);
	
	/**
	 * 根据id获取playmovie对象
	 * @param id
	 * @return
	 */
	ResourcePO getById(String id);
	
	/**
	 * 修改resourcePO
	 * @param resourcePO
	 */
	void update(ResourcePO resourcePO);
	
	/**
	 * 获取所有许可，一般不会用此方式
	 * @return
	 */
	List<ResourcePO> getAll();

	/**
	 * 根据type获取所有resourcePO对象，一般不会用此方式
	 * @param type
	 * @return
	 */
	List<ResourcePO> getByType(String type);

	/**
	 * 根据info获取List<resourcePO>一般不会用此方式
	 * @param info
	 * @return
	 */
	List<ResourcePO> getByInfo(String info);

	/**
	 * 根据条件获取List<resourcePO> （service未实现）
	 * @param info
	 * @return
	 */
	List<ResourcePO> getByCondetion(ResourcePO condetion);
	
	/**
	 * 根据条件和页数据获取当前页数据，一般用此方法，使用resourcePO类做条件类（简化）
	 * @return
	 */
	List<ResourcePO> getByCondetionPage(ResourcePO condetion);
	
	/**
	 * 根据条件获取总记录条数
	 * @return
	 */
	Long getTotal(ResourcePO condetion);
	
	/**
	 * 根据特殊字段获取录条数
	 * @return
	 */
	Long getSpecialTotal(ResourcePO condetion);
	
	/**
	 * 获取推荐影片、资源 2017-1-27添加字段及相关方法
	 * @param info
	 * @return
	 */
	List<ResourcePO> getSpecial(ResourcePO resourcePO);
	
}
