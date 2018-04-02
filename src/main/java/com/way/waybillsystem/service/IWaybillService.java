package com.way.waybillsystem.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.Waybill;
import com.way.waybillsystem.vo.QueryByPageObject;

/**
 * 
* @author Way Leung
* @Description: TODO(用一句话描述该文件做什么)   
* @date 2018年2月17日
 */


public interface IWaybillService {
	int insertWaybill(Waybill waybill);
	
	int deleteWaybillByPrimaryKey(Long id);
	
	int updateWaybillByPrimarykey(Waybill waybill);
	
	Waybill selectWaybillByPrimaryKey(Long id);
	
	List<Waybill> selectAllWaybills();
	
	PageInfo<Waybill> selectAllWaybillsByPage(QueryByPageObject queryObject);

	Waybill selectWaybillByWaybillNumber(Long waybillNumber);
	
}
