package com.way.waybillsystem.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.CodeTokenOpenid;
import com.way.waybillsystem.entity.User;
import com.way.waybillsystem.entity.WechatToken;
import com.way.waybillsystem.mapper.AdminMapper;
import com.way.waybillsystem.service.ICodeTokenOpenidService;
import com.way.waybillsystem.service.IWechatTokenService;
import com.way.waybillsystem.util.WechatUtil;
import com.way.waybillsystem.vo.QueryByPageObject;
import com.way.waybillsystem.vo.Result;

import net.sf.json.JSONObject;


@Controller
/*public class WechatTokenAction extends BaseAction {*/
public class WechatAction  extends BaseAction {
	
	private Logger logger = LoggerFactory.getLogger(WechatAction.class);
	
	@Autowired
	private IWechatTokenService wechatTokenService;
	
	@Autowired
	private ICodeTokenOpenidService codeTokenOpenidService; 
	
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
	
	
	//@RequestMapping(value="/wechatJoinUp",method=RequestMethod.GET)
	@RequestMapping(value="/wechatJoinUp")
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
		if(WechatUtil.checkSignature(token, signature, timestamp, nonce)){
			out.print(echostr);
			logger.debug("微信接入成功"+echostr);
		}else{
			logger.debug("微信接入失败");
		}
	}
	
	/**
	 * 
	 * 创建微信菜单
	 * https请求方式: GET
		https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/createMenu",method=RequestMethod.POST)
	@ResponseBody
	public Result<String> createMenu(HttpServletRequest request,HttpServletResponse response){
		String menu = JSONObject.fromObject(WechatUtil.initMenu()).toString();
		WechatToken token = wechatTokenService.getAndSaveAccessToken();
		String data = WechatUtil.createMenu(token.getToken(), menu);
		return new Result<String>(true, data, "创建微信菜单", "1");
	}
	
	
	/**
	 * 网页授权
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping(value="/wechatUserLogin",method=RequestMethod.GET)
	public void wechatUserLogin(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		//登陆后的回调地址
		/*
		 * 尤其注意：跳转回调redirect_uri，应当使用https链接来确保授权code的安全性。
		 * 记得在测试账号 下面的接口列表中 添加 
		 * 网页服务	网页帐号	网页授权获取用户基本信息 添加回调页面不然会出错
		 */
		String back_url = "http://wayleung80.tunnel.echomod.cn/logincallback";
		//System.out.println(URLEncoder.encode(back_url));
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+WechatUtil.getAppid()+"&redirect_uri="+URLEncoder.encode(back_url)+"&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect"; 
		resp.sendRedirect(url);
	}
	
	
	/**
	 * 微信授权登陆后 回调地址
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 * @throws ServletException 
	 */
	@RequestMapping(value="/logincallback",method=RequestMethod.GET)
	public void loginCallback(HttpSession session, HttpServletRequest req,HttpServletResponse resp) throws ClientProtocolException, IOException, ServletException{
		/*code说明 ： code作为换取access_token的票据，每次用户授权带上的code将不一样，code只能使用一次，5分钟未被使用自动过期。*/ 
		
		String code = req.getParameter("code");
		System.out.println("--code:"+code);
		//通过code换取网页授权access_token
		//这个access_token跟那个不一样？
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+WechatUtil.getAppid()+"&secret="+WechatUtil.getAppsecret()+"&code="+code+"&grant_type=authorization_code";
		JSONObject jsonObject = WechatUtil.doGetStr(url);
		System.out.println("--jsonObject:"+jsonObject);
		String token =""; 
		String openid ="";
		CodeTokenOpenid code_db = codeTokenOpenidService.selectTokenByCode(code);
		if(code_db==null){
			 token = jsonObject.getString("access_token");
			 openid = jsonObject.getString("openid");
			 CodeTokenOpenid code_temp = new CodeTokenOpenid();
			 code_temp.setCode(code);
			 code_temp.setOpenid(openid);
			 code_temp.setToken(token);
			 codeTokenOpenidService.insertCodeTokenOpenid(code_temp);
		}else{
			 token = code_db.getToken();
			 openid = code_db.getOpenid();

		}
		
		/*
		 * 把openid存进session
		 */

		session.setAttribute("openid", openid);

		//获取用户信息
		String infoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token="+token+"&openid="+openid+"&lang=zh_CN";
		JSONObject userinfo = WechatUtil.doGetStr(infoUrl);
		System.out.println("--userinfo:"+userinfo);
		
		//1.使用微信用户信息直接登陆 无需注册和绑定
		//req.setAttribute("info", userinfo);
		/*req.getRequestDispatcher("../userlogin.jsp").forward(req, resp);*/
		resp.sendRedirect("http://wayleung80.tunnel.echomod.cn/user/index.html");
		//绑定微信
		//req.getRequestDispatcher("/wechatbind.jsp").forward(req, resp);
		
		
		//2.将微信与当前系统的账号绑定
		
		
		//return "user/index.html";
	}
	


	
	
	
	
	@RequestMapping(value="/testSendTemplateMessage",method=RequestMethod.GET)
	public void testSendTemplateMessage(){
		WechatToken accessToken = wechatTokenService.getAndSaveAccessToken();
		String access_token = accessToken.getToken();
		WechatUtil.testSendTemplateMessage("oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ", access_token);
	}
}
