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
import com.way.waybillsystem.entity.PayOption;
import com.way.waybillsystem.entity.PayOptionExample;
import com.way.waybillsystem.mapper.PayOptionMapper;
import com.way.waybillsystem.service.IPayOptionService;
import com.way.waybillsystem.vo.QueryByPageObject;

@Service
public class PayOptionServiceImpl implements IPayOptionService {
	@Autowired
	private PayOptionMapper payOptionMapper;
	
	private Logger Logger = LoggerFactory.getLogger(PayOptionMapper.class);
	
	@Override
	@Transactional
	public int insertPayOption(PayOption payOption) {
		// TODO Auto-generated method stub
		return payOptionMapper.insertSelective(payOption);
	}

	@Override
	@Transactional
	public int deletePayOptionByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return payOptionMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional
	public int updatePayOptionByPrimarykey(PayOption payOption) {
		// TODO Auto-generated method stub
		return payOptionMapper.updateByPrimaryKeySelective(payOption);
	}

	@Override
	public PayOption selectPayOptionByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return payOptionMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<PayOption> selectAllPayOptions() {
		// TODO Auto-generated method stub
		PayOptionExample example = new PayOptionExample();
		return payOptionMapper.selectByExample(example);
	}

	@Override
	public PageInfo<PayOption> selectAllPayOptionsByPage(QueryByPageObject queryObject) {
		// TODO Auto-generated method stub
		PageHelper.startPage(queryObject.getCurrentPage(), queryObject.getPageSize());
		//pagehelper不是内存分页是物理分页 PageHelper只对紧跟着的第一个SQL语句起作用
		PayOptionExample example = new PayOptionExample();
		List<PayOption> list =  payOptionMapper.selectByExample(example);
		PageInfo<PayOption> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

}
