package com.way.waybillsystem.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.WechatToken;
import com.way.waybillsystem.vo.QueryByPageObject;

/**
 * 
* @author Way Leung
* @Description: TODO(用一句话描述该文件做什么)   
* @date 2018年2月17日
 */


public interface IWechatTokenService {
	int insertWechatToken(WechatToken wechattoken);
	
	int deleteWechatTokenByPrimaryKey(Long id);
	
	int updateWechatTokenByPrimarykey(WechatToken wechattoken);
	
	WechatToken selectWechatTokenByPrimaryKey(Long id);
	
	List<WechatToken> selectAllWechatTokens();
	
	PageInfo<WechatToken> selectAllWechatTokensByPage(QueryByPageObject queryObject);
	
	WechatToken selectLastWechatToken();
	
	WechatToken getAndSaveAccessToken();
	

}
