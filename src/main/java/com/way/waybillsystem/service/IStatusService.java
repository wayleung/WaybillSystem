package com.way.waybillsystem.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.Status;
import com.way.waybillsystem.vo.QueryByPageObject;

/**
 * 
* @author Way Leung
* @Description: TODO(用一句话描述该文件做什么)   
* @date 2018年2月17日
 */


public interface IStatusService {
	int insertStatus(Status status);
	
	int deleteStatusByPrimaryKey(Integer id);
	
	int updateStatusByPrimarykey(Status status);
	
	Status selectStatusByPrimaryKey(Integer id);
	
	List<Status> selectAllStatuss();
	
	PageInfo<Status> selectAllStatussByPage(QueryByPageObject queryObject);
	
}
