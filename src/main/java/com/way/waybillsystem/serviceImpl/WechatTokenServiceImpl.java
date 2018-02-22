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
import com.way.waybillsystem.entity.WechatToken;
import com.way.waybillsystem.entity.WechatTokenExample;
import com.way.waybillsystem.mapper.WechatTokenMapper;
import com.way.waybillsystem.service.IWechatTokenService;
import com.way.waybillsystem.vo.QueryByPageObject;

@Service
public class WechatTokenServiceImpl implements IWechatTokenService {
	@Autowired
	private WechatTokenMapper wechatTokenMapper;
	
	private Logger Logger = LoggerFactory.getLogger(WechatTokenMapper.class);
	
	@Override
	@Transactional
	public int insertWechatToken(WechatToken wechatToken) {
		// TODO Auto-generated method stub
		wechatToken.setCreateTime(new Date());
		return wechatTokenMapper.insertSelective(wechatToken);
	}

	@Override
	@Transactional
	public int deleteWechatTokenByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return wechatTokenMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional
	public int updateWechatTokenByPrimarykey(WechatToken wechatToken) {
		// TODO Auto-generated method stub
		return wechatTokenMapper.updateByPrimaryKeySelective(wechatToken);
	}

	@Override
	public WechatToken selectWechatTokenByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return wechatTokenMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<WechatToken> selectAllWechatTokens() {
		// TODO Auto-generated method stub
		WechatTokenExample example = new WechatTokenExample();
		return wechatTokenMapper.selectByExample(example);
	}

	@Override
	public PageInfo<WechatToken> selectAllWechatTokensByPage(QueryByPageObject queryObject) {
		// TODO Auto-generated method stub
		PageHelper.startPage(queryObject.getCurrentPage(), queryObject.getPageSize());
		//pagehelper不是内存分页是物理分页 PageHelper只对紧跟着的第一个SQL语句起作用
		WechatTokenExample example = new WechatTokenExample();
		List<WechatToken> list =  wechatTokenMapper.selectByExample(example);
		PageInfo<WechatToken> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

}
