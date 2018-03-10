package com.way.waybillsystem.serviceImpl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.WechatToken;
import com.way.waybillsystem.entity.WechatTokenExample;
import com.way.waybillsystem.entity.WechatTokenExample.Criteria;
import com.way.waybillsystem.mapper.WechatTokenMapper;
import com.way.waybillsystem.service.IWechatTokenService;
import com.way.waybillsystem.util.WechatUtil;
import com.way.waybillsystem.vo.QueryByPageObject;
import com.way.waybillsystem.wechat.entity.AccessToken;

@Service
public class WechatTokenServiceImpl implements IWechatTokenService {
	@Autowired
	private WechatTokenMapper wechatTokenMapper;
	
	private Logger logger = LoggerFactory.getLogger(WechatTokenMapper.class);
	
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
	
	@Override
	public WechatToken selectLastWechatToken() {
		// TODO Auto-generated method stub
		return  wechatTokenMapper.selectLastWechatToken();
	}

	@Override
	public WechatToken getAndSaveAccessToken() {
		// TODO Auto-generated method stub
		WechatToken lastWechatToken = selectLastWechatToken();
		if(lastWechatToken==null||StringUtils.isEmpty(lastWechatToken.getToken())){
			//数据库为空 不存在access_token
			AccessToken accessToken = WechatUtil.getAccessToken();
			String access_token = accessToken.getAccess_token();
			WechatToken wechatToken = new WechatToken();
			wechatToken.setToken(access_token);
			insertWechatToken(wechatToken);
			logger.debug("数据库为空 不存在access_token 从微信服务器获取最新access_token："+access_token+"并存入数据库！");
			return wechatToken;
		}else{
			Date lastTokenTime = lastWechatToken.getCreateTime();
			Date now =  new Date();
			//把数据库最新的access的时间跟现在的时间比较秒数 看是否大于5400s  1.5h    7200s （两小时）来看是否需要去微信服务器获取access_token
			long distance_time =  (now.getTime()-lastTokenTime.getTime())/1000;
			if(distance_time>=5400){
				//大于1.5h 
				AccessToken accessToken = WechatUtil.getAccessToken();
				String access_token = accessToken.getAccess_token();
				WechatToken wechatToken = new WechatToken();
				wechatToken.setToken(access_token);
				insertWechatToken(wechatToken);
				logger.debug("现在与数据库最新access_token相差"+distance_time+ "s,>1.5h"+"从微信服务器获取最新access_token："+access_token+"并存入数据库！");
				return wechatToken;
			}else{
				logger.debug("现在与数据库最新access_token相差"+distance_time+ "s,<1.5h"+"不需微信服务器获取最新access_token");
				return lastWechatToken;
			}
		}

	}



}
