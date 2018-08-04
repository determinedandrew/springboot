package com.ggc.ms.pojo;

import java.util.List;
/**
 * @description 分页对象实体类
 * @author eleven
 *
 * @param <T>
 */
public class PaginationVO<T> {
	
	private Long total;
	private List<T> dataList;

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

}
