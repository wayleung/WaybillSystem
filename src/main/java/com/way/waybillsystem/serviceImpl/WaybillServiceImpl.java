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
import com.way.waybillsystem.entity.Waybill;
import com.way.waybillsystem.entity.WaybillExample;
import com.way.waybillsystem.mapper.WaybillMapper;
import com.way.waybillsystem.service.IWaybillService;
import com.way.waybillsystem.vo.QueryByPageObject;

@Service
public class WaybillServiceImpl implements IWaybillService {
	@Autowired
	private WaybillMapper waybillMapper;
	
	private Logger Logger = LoggerFactory.getLogger(WaybillMapper.class);
	
	@Override
	@Transactional
	public int insertWaybill(Waybill waybill) {
		// TODO Auto-generated method stub
		waybill.setCreateTime(new Date());
		return waybillMapper.insertSelective(waybill);
	}

	@Override
	@Transactional
	public int deleteWaybillByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return waybillMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional
	public int updateWaybillByPrimarykey(Waybill waybill) {
		// TODO Auto-generated method stub
		return waybillMapper.updateByPrimaryKeySelective(waybill);
	}

	@Override
	public Waybill selectWaybillByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return waybillMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Waybill> selectAllWaybills() {
		// TODO Auto-generated method stub
		WaybillExample example = new WaybillExample();
		return waybillMapper.selectByExample(example);
	}

	@Override
	public PageInfo<Waybill> selectAllWaybillsByPage(QueryByPageObject queryObject) {
		// TODO Auto-generated method stub
		PageHelper.startPage(queryObject.getCurrentPage(), queryObject.getPageSize());
		//pagehelper不是内存分页是物理分页 PageHelper只对紧跟着的第一个SQL语句起作用
		WaybillExample example = new WaybillExample();
		List<Waybill> list =  waybillMapper.selectByExample(example);
		PageInfo<Waybill> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

}
