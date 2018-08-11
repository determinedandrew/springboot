package com.gg.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gg.springboot.model.RiskInfo;
@Mapper
public interface IRiskInfoMapper {
	RiskInfo getRiskInfo(RiskInfo riskInfo);
	List<RiskInfo> getRiskInfos(RiskInfo riskInfo);
}
