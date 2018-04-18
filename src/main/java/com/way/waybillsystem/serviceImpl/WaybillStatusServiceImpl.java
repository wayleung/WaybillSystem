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
import com.way.waybillsystem.entity.WaybillStatus;
import com.way.waybillsystem.entity.WaybillStatusExample;
import com.way.waybillsystem.mapper.WaybillStatusMapper;
import com.way.waybillsystem.service.IWaybillStatusService;
import com.way.waybillsystem.vo.QueryByPageObject;

@Service
public class WaybillStatusServiceImpl implements IWaybillStatusService {
	@Autowired
	private WaybillStatusMapper waybillStatusMapper;
	
	private Logger Logger = LoggerFactory.getLogger(WaybillStatusServiceImpl.class);
	
	@Override
	@Transactional
	public int insertWaybillStatus(WaybillStatus waybillStatus) {
		// TODO Auto-generated method stub
		waybillStatus.setCreateTime(new Date());
		return waybillStatusMapper.insertSelective(waybillStatus);
	}

	@Override
	@Transactional
	public int deleteWaybillStatusByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return waybillStatusMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional
	public int updateWaybillStatusByPrimarykey(WaybillStatus waybillStatus) {
		// TODO Auto-generated method stub
		return waybillStatusMapper.updateByPrimaryKeySelective(waybillStatus);
	}

	@Override
	public WaybillStatus selectWaybillStatusByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return waybillStatusMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<WaybillStatus> selectAllWaybillStatuss() {
		// TODO Auto-generated method stub
		WaybillStatusExample example = new WaybillStatusExample();
		return waybillStatusMapper.selectByExample(example);
	}

	@Override
	public PageInfo<WaybillStatus> selectAllWaybillStatussByPage(QueryByPageObject queryObject) {
		// TODO Auto-generated method stub
		PageHelper.startPage(queryObject.getCurrentPage(), queryObject.getPageSize());
		//pagehelper不是内存分页是物理分页 PageHelper只对紧跟着的第一个SQL语句起作用
		WaybillStatusExample example = new WaybillStatusExample();
		List<WaybillStatus> list =  waybillStatusMapper.selectByExample(example);
		PageInfo<WaybillStatus> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public List<WaybillStatus> selectWaybillStatusByWaybillNumber(Long waybillNumber) {
		// TODO Auto-generated method stub
		return waybillStatusMapper.selectWaybillStatusByWaybillNumber(waybillNumber);
	}

	@Override
	public void deleteWaybillStatusByWaybillNumber(Long waybillNumber) {
		// TODO Auto-generated method stub
		List<WaybillStatus> list = selectWaybillStatusByWaybillNumber(waybillNumber);
		for (WaybillStatus waybillStatus : list) {
			waybillStatusMapper.deleteByPrimaryKey(waybillStatus.getWsId());
		}
		
	}

}
