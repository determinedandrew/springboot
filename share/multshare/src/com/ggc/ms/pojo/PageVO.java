package com.ggc.ms.pojo;
/**
 * 
 * @author eleven
 * 在本类中对pageNo、pageSize赋值set，起始数、结束数本类处理完成（调用get时处理）
 */
public class PageVO {
	public Integer pageNo;
	public Integer pageSize;
	public Integer startNo;
	//public Integer endNo;
	
	
	public void setStartNo(Integer startNo) {
		this.startNo = startNo;
	}
	public Integer getStartNo() {
		return startNo;
	}
	
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
