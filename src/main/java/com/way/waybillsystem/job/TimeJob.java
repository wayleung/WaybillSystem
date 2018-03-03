package com.way.waybillsystem.job;

import org.springframework.beans.factory.annotation.Autowired;

import com.way.waybillsystem.service.IWechatTokenService;

public class TimeJob {
	@Autowired
	IWechatTokenService wechatTokenService;
	
	public void getAndSaveAccessTokenJob(){
		wechatTokenService.getAndSaveAccessToken();
	}
}
