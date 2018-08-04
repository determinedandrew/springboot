package com.ggc.ms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ggc.ms.dao.IResourceDao;
import com.ggc.ms.pojo.PaginationVO;
import com.ggc.ms.pojo.ResourcePO;
import com.ggc.ms.service.IResourceService;

@Service("resourceService")
public class ResourceServiceImpl implements IResourceService {
	
	@Resource(name="IResourceDao")
	private IResourceDao resourceDao;

	@Override
	public void add(ResourcePO resourcePO) {
		resourceDao.insert(resourcePO);
	}

	@Override
	public void batchAdd(List<ResourcePO> resourcePOs) {
		resourceDao.batchInsert(resourcePOs);
	}

	@Override
	public void removeById(String reid) {
		resourceDao.deleteById(reid);
		
	}

	@Override
	public void batchRemoveById(List<String> reids) {
		resourceDao.batchDeleteById(reids);
	}

	@Override
	public ResourcePO getById(String id) {
		return resourceDao.getById(id);
	}

	@Override
	public void modify(ResourcePO resourcePO) {
		resourceDao.update(resourcePO);
	}

	@Override
	public List<ResourcePO> getAll() {
		return resourceDao.getAll();
	}

	@Override
	public List<ResourcePO> getByType(String type) {
		return resourceDao.getByType(type);
	}

	@Override
	public List<ResourcePO> getByInfo(String info) {
		return resourceDao.getByInfo(info);
	}

	/**
	 * 通过条件返回页面数据
	 * @param condetion
	 * @return
	 */
	@Override
	public PaginationVO<ResourcePO> getByCondetionPage(ResourcePO resourcePO) {
		Integer pageNo = resourcePO.getPageNo();
		Integer pageSize = resourcePO.getPageSize();
		resourcePO.setStartNo((pageNo-1)*pageSize);
		
		PaginationVO<ResourcePO> pg = new PaginationVO<ResourcePO>();
		List<ResourcePO> resourcePOs = resourceDao.getByCondetionPage(resourcePO);
		Long total = resourceDao.getTotal(resourcePO);
		pg.setDataList(resourcePOs);
		pg.setTotal(total);
		return pg;
	}

	@Override
	public PaginationVO<ResourcePO> getSpecial(ResourcePO resourcePO) {
		PaginationVO<ResourcePO> pg = new PaginationVO<ResourcePO>();
		List<ResourcePO> resourcePOs = resourceDao.getSpecial(resourcePO);
		Long total = resourceDao.getSpecialTotal(resourcePO);
		pg.setDataList(resourcePOs);
		pg.setTotal(total);
		return pg;
	}

	
}
