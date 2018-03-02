package com.way.waybillsystem.serviceImpl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.Location;
import com.way.waybillsystem.entity.LocationExample;
import com.way.waybillsystem.mapper.LocationMapper;
import com.way.waybillsystem.service.ILocationService;
import com.way.waybillsystem.vo.QueryByPageObject;

@Service
public class LocationServiceImpl implements ILocationService {
	@Autowired
	private LocationMapper locationMapper;
	
	private Logger Logger = LoggerFactory.getLogger(LocationMapper.class);
	
	@Override
	@Transactional
	public int insertLocation(Location location) {
		// TODO Auto-generated method stub
		return locationMapper.insertSelective(location);
	}

	@Override
	@Transactional
	public int deleteLocationByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return locationMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional
	public int updateLocationByPrimarykey(Location location) {
		// TODO Auto-generated method stub
		return locationMapper.updateByPrimaryKeySelective(location);
	}

	@Override
	public Location selectLocationByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return locationMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Location> selectAllLocations() {
		// TODO Auto-generated method stub
		LocationExample example = new LocationExample();
		return locationMapper.selectByExample(example);
	}

	@Override
	public PageInfo<Location> selectAllLocationsByPage(QueryByPageObject queryObject) {
		// TODO Auto-generated method stub
		PageHelper.startPage(queryObject.getCurrentPage(), queryObject.getPageSize());
		//pagehelper不是内存分页是物理分页 PageHelper只对紧跟着的第一个SQL语句起作用
		LocationExample example = new LocationExample();
		List<Location> list =  locationMapper.selectByExample(example);
		PageInfo<Location> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

}
