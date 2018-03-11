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
import com.way.waybillsystem.entity.Status;
import com.way.waybillsystem.entity.StatusExample;
import com.way.waybillsystem.mapper.StatusMapper;
import com.way.waybillsystem.service.IStatusService;
import com.way.waybillsystem.vo.QueryByPageObject;

@Service
public class StatusServiceImpl implements IStatusService {
	@Autowired
	private StatusMapper statusMapper;
	
	private Logger Logger = LoggerFactory.getLogger(StatusServiceImpl.class);
	
	@Override
	@Transactional
	public int insertStatus(Status status) {
		// TODO Auto-generated method stub
		return statusMapper.insertSelective(status);
	}

	@Override
	@Transactional
	public int deleteStatusByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return statusMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional
	public int updateStatusByPrimarykey(Status status) {
		// TODO Auto-generated method stub
		return statusMapper.updateByPrimaryKeySelective(status);
	}

	@Override
	public Status selectStatusByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return statusMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Status> selectAllStatuss() {
		// TODO Auto-generated method stub
		StatusExample example = new StatusExample();
		return statusMapper.selectByExample(example);
	}

	@Override
	public PageInfo<Status> selectAllStatussByPage(QueryByPageObject queryObject) {
		// TODO Auto-generated method stub
		PageHelper.startPage(queryObject.getCurrentPage(), queryObject.getPageSize());
		//pagehelper不是内存分页是物理分页 PageHelper只对紧跟着的第一个SQL语句起作用
		StatusExample example = new StatusExample();
		List<Status> list =  statusMapper.selectByExample(example);
		PageInfo<Status> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

}
