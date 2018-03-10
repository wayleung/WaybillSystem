package com.way.waybillsystem.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.WaybillStatus;
import com.way.waybillsystem.vo.QueryByPageObject;

/**
 * 
* @author Way Leung
* @Description: TODO(用一句话描述该文件做什么)   
* @date 2018年2月17日
 */


public interface IWaybillStatusService {
	int insertWaybillStatus(WaybillStatus waybillStatus);
	
	int deleteWaybillStatusByPrimaryKey(Long id);
	
	int updateWaybillStatusByPrimarykey(WaybillStatus waybillStatus);
	
	WaybillStatus selectWaybillStatusByPrimaryKey(Long id);
	
	List<WaybillStatus> selectAllWaybillStatuss();
	
	PageInfo<WaybillStatus> selectAllWaybillStatussByPage(QueryByPageObject queryObject);
	
	List<WaybillStatus> selectWaybillStatusByWaybillNumber(Long waybillNumber);
}
