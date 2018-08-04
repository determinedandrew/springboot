package com.ggc.ms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ggc.ms.dao.ICommenDao;
import com.ggc.ms.pojo.CommenPO;
import com.ggc.ms.service.ICommenService;

@Service("commenService")
public class CommenServiceImpl implements ICommenService {
	
	@Resource(name="ICommenDao")
	private ICommenDao commenDao;

	@Override
	public void add(CommenPO commenPO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CommenPO getByCcode(String ccode) {
		return commenDao.getByCcode(ccode);
	}

	@Override
	public void update(CommenPO commenPO) {
		// TODO Auto-generated method stub
		
	}


	
}
