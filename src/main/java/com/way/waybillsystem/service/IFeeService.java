package com.way.waybillsystem.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.Fee;
import com.way.waybillsystem.vo.QueryByPageObject;

public interface IFeeService {
	int insertFee(Fee fee);
	
	int deleteFeeByPrimaryKey(Integer id);
	
	int updateFeeByPrimarykey(Fee fee);
	
	Fee selectFeeByPrimaryKey(Integer id);
	
	List<Fee> selectAllFees();
	
	PageInfo<Fee> selectAllFeesByPage(QueryByPageObject queryObject);
}
