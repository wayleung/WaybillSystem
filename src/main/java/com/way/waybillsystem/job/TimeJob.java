package com.way.waybillsystem.job;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.way.waybillsystem.service.IWechatTokenService;

public class TimeJob {
	@Resource
	IWechatTokenService wechatTokenService;
	
	public void getAndSaveAccessTokenJob(){
		wechatTokenService.getAndSaveAccessToken();
	}
}
