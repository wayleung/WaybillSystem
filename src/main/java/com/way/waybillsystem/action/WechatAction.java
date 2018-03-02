package com.way.waybillsystem.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.WechatToken;
import com.way.waybillsystem.mapper.AdminMapper;
import com.way.waybillsystem.service.IWechatTokenService;
import com.way.waybillsystem.util.WechatCheckUtil;
import com.way.waybillsystem.vo.QueryByPageObject;


@Controller
/*public class WechatTokenAction extends BaseAction {*/
public class WechatAction  extends BaseAction {
	
	private Logger logger = LoggerFactory.getLogger(WechatAction.class);
	
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
	
	
	@RequestMapping(value="/wechatJoinUp",method=RequestMethod.GET)
	@ResponseBody
	public void wechatJoinup(HttpServletRequest request,HttpServletResponse response) throws IOException{
	    // 将请求、响应的编码均设置为UTF-8（防止中文乱码）  
        request.setCharacterEncoding("UTF-8");  //微信服务器POST消息时用的是UTF-8编码，在接收时也要用同样的编码，否则中文会乱码；
        response.setCharacterEncoding("UTF-8"); //在响应消息（回复消息给用户）时，也将编码方式设置为UTF-8，原理同上
//		signature	微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
//		timestamp	时间戳
//		nonce	随机数
//		echostr	随机字符串

		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		String token = "WaybillSystem";
		
		PrintWriter out = response.getWriter();
		if(WechatCheckUtil.checkSignature(token, signature, timestamp, nonce)){
			out.print(echostr);
			logger.debug("微信接入成功"+echostr);
		}else{
			logger.debug("微信接入失败");
		}
	}
	
	/**
	 * https请求方式: GET
		https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/getAccessToken",method=RequestMethod.GET)
	@ResponseBody
	public void getAccessToken(HttpServletRequest request,HttpServletResponse response){
		
	}

}
