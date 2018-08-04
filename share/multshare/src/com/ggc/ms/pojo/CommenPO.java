package com.ggc.ms.pojo;
/**
 * 
 * @author eleven
 * 在本类中对pageNo、pageSize赋值set，起始数、结束数本类处理完成（调用get时处理）
 */
public class CommenPO {
	public String cname;
	public String ccode;
	public String cvalue;
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCcode() {
		return ccode;
	}
	public void setCcode(String ccode) {
		this.ccode = ccode;
	}
	public String getCvalue() {
		return cvalue;
	}
	public void setCvalue(String cvalue) {
		this.cvalue = cvalue;
	}
	
}
