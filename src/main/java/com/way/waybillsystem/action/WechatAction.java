package com.way.waybillsystem.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.WechatToken;
import com.way.waybillsystem.service.IWechatTokenService;
import com.way.waybillsystem.vo.QueryByPageObject;


@Controller
/*public class WechatTokenAction extends BaseAction {*/
public class WechatAction  extends BaseAction {
	@Autowired
	private IWechatTokenService wechatTokenService;
	
	@RequestMapping(value="/insertWechatToken",method=RequestMethod.POST)
	@ResponseBody
	public void insertWechatToken(WechatToken wechatToken){
		wechatTokenService.insertWechatToken(wechatToken);
	}
	
	@RequestMapping(value="/deleteWechatTokenByPrimaryKey",method=RequestMethod.POST)
	@ResponseBody
	public void deleteWechatTokenByPrimaryKey(Long id){
		wechatTokenService.deleteWechatTokenByPrimaryKey(id);
	}

}
