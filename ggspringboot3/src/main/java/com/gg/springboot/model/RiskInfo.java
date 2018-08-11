package com.gg.springboot.model;

public class RiskInfo {
	private String riskCode;
	private String riskName;
	private String payIntv;
	private String payPeriod;
	private String amount;
	private String insuYear;
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public String getRiskName() {
		return riskName;
	}
	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}
	public String getPayIntv() {
		return payIntv;
	}
	public void setPayIntv(String payIntv) {
		this.payIntv = payIntv;
	}
	public String getPayPeriod() {
		return payPeriod;
	}
	public void setPayPeriod(String payPeriod) {
		this.payPeriod = payPeriod;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getInsuYear() {
		return insuYear;
	}
	public void setInsuYear(String insuYear) {
		this.insuYear = insuYear;
	}
	@Override
	public String toString() {
		return "RiskInfo [riskCode=" + riskCode + ", riskName=" + riskName + ", payIntv=" + payIntv + ", payPeriod="
				+ payPeriod + ", amount=" + amount + ", insuYear=" + insuYear + "]";
	}
	
	
}
