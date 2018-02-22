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
import com.way.waybillsystem.entity.PayCharge;
import com.way.waybillsystem.entity.PayChargeExample;
import com.way.waybillsystem.mapper.PayChargeMapper;
import com.way.waybillsystem.service.IPayChargeService;
import com.way.waybillsystem.vo.QueryByPageObject;

@Service
public class PayChargeServiceImpl implements IPayChargeService {
	@Autowired
	private PayChargeMapper payChargeMapper;
	
	private Logger Logger = LoggerFactory.getLogger(PayChargeMapper.class);
	
	@Override
	@Transactional
	public int insertPayCharge(PayCharge payCharge) {
		// TODO Auto-generated method stub
		return payChargeMapper.insertSelective(payCharge);
	}

	@Override
	@Transactional
	public int deletePayChargeByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return payChargeMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional
	public int updatePayChargeByPrimarykey(PayCharge payCharge) {
		// TODO Auto-generated method stub
		return payChargeMapper.updateByPrimaryKeySelective(payCharge);
	}

	@Override
	public PayCharge selectPayChargeByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return payChargeMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<PayCharge> selectAllPayCharges() {
		// TODO Auto-generated method stub
		PayChargeExample example = new PayChargeExample();
		return payChargeMapper.selectByExample(example);
	}

	@Override
	public PageInfo<PayCharge> selectAllPayChargesByPage(QueryByPageObject queryObject) {
		// TODO Auto-generated method stub
		PageHelper.startPage(queryObject.getCurrentPage(), queryObject.getPageSize());
		//pagehelper不是内存分页是物理分页 PageHelper只对紧跟着的第一个SQL语句起作用
		PayChargeExample example = new PayChargeExample();
		List<PayCharge> list =  payChargeMapper.selectByExample(example);
		PageInfo<PayCharge> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

}
