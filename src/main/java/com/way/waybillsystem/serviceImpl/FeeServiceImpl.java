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
import com.way.waybillsystem.entity.Fee;
import com.way.waybillsystem.entity.FeeExample;
import com.way.waybillsystem.mapper.FeeMapper;
import com.way.waybillsystem.service.IFeeService;
import com.way.waybillsystem.vo.QueryByPageObject;

@Service
public class FeeServiceImpl implements IFeeService {
	@Autowired
	private FeeMapper feeMapper;
	
	private Logger Logger = LoggerFactory.getLogger(FeeServiceImpl.class);
	
	@Override
	@Transactional
	public int insertFee(Fee fee) {
		// TODO Auto-generated method stub
		return feeMapper.insertSelective(fee);
	}

	@Override
	@Transactional
	public int deleteFeeByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return feeMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional
	public int updateFeeByPrimarykey(Fee fee) {
		// TODO Auto-generated method stub
		return feeMapper.updateByPrimaryKeySelective(fee);
	}

	@Override
	public Fee selectFeeByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return feeMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Fee> selectAllFees() {
		// TODO Auto-generated method stub
		FeeExample example = new FeeExample();
		return feeMapper.selectByExample(example);
	}

	@Override
	public PageInfo<Fee> selectAllFeesByPage(QueryByPageObject queryObject) {
		// TODO Auto-generated method stub
		PageHelper.startPage(queryObject.getCurrentPage(), queryObject.getPageSize());
		//pagehelper不是内存分页是物理分页 PageHelper只对紧跟着的第一个SQL语句起作用
		FeeExample example = new FeeExample();
		List<Fee> list =  feeMapper.selectByExample(example);
		PageInfo<Fee> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

}
