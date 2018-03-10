package com.way.waybillsystem.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.Location;
import com.way.waybillsystem.vo.QueryByPageObject;

public interface ILocationService {
	int insertLocation(Location location);
	
	int deleteLocationByPrimaryKey(Integer id);
	
	int updateLocationByPrimarykey(Location location);
	
	Location selectLocationByPrimaryKey(Integer id);
	
	List<Location> selectAllLocations();
	
	PageInfo<Location> selectAllLocationsByPage(QueryByPageObject queryObject);
}
