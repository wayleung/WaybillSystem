package com.way.waybillsystem.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.User;
import com.way.waybillsystem.exception.ErrorCodeConstant;
import com.way.waybillsystem.service.IUserService;
import com.way.waybillsystem.vo.QueryByPageObject;
import com.way.waybillsystem.vo.Result;


@Controller
/*public class UserAction extends BaseAction {*/

public class UserAction  extends BaseAction {
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/insertUser",method=RequestMethod.POST)
	@ResponseBody
	public void insertUser(User user){
		userService.insertUser(user);
	}
	
	@RequestMapping(value="/deleteUserByPrimaryKey",method=RequestMethod.POST)
	@ResponseBody
	public void deleteUserByPrimaryKey(Long id){
		userService.deleteUserByPrimaryKey(id);
	}
	
	@RequestMapping(value="/updateUserByPrimarykey",method=RequestMethod.POST)
	@ResponseBody
	public void updateUserByPrimarykey(User user){
		userService.updateUserByPrimarykey(user);
	}
	
	@RequestMapping(value="/selectAllUsers",method=RequestMethod.GET)
	@ResponseBody
	public Result<List<User>> selectAllUsers(){
		List<User> data = userService.selectAllUsers();
		/*return userService.selectAllUsers();*/
		return new Result<List<User>>(true, data, "查询Users表成功！", "1");
	}

	
	@RequestMapping(value="/selectUserByPrimaryKey",method=RequestMethod.GET)
	@ResponseBody
	public User selectUserByPrimaryKey(Long id){
		return userService.selectUserByPrimaryKey(id);
	}
	
	
	@RequestMapping(value="/selectUserByAccount",method=RequestMethod.GET)
	@ResponseBody
	public Result selectUserByAccount(String account){
		User user = userService.selectUserByAccount(account);
		if(user!=null){
			return new Result<User>(true, user, "查询Users表成功！", "1");
		}else{
			return new Result(false, "该账号用户不存在", "0");
		}
	}
	
	@RequestMapping(value="/selectAllUsersByPage",method=RequestMethod.GET)
	@ResponseBody
	public PageInfo<User> selectAllUsersByPage(QueryByPageObject queryObject){
		return userService.selectAllUsersByPage(queryObject);
	}
	
	
	
	
	
	@RequestMapping(value="/wechatBind",method=RequestMethod.POST)
	@ResponseBody
	public Result wechatBind(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String openid =  (String) request.getSession().getAttribute("openid");
		
		User user =  (User) request.getSession().getAttribute("user");
		if(StringUtils.isBlank(openid)||user==null){
			return new Result<>(false,ErrorCodeConstant.E00009.getMessage(),ErrorCodeConstant.E00009.getCode());
		}else{
			userService.wechatBind(user, openid);
			//response.sendRedirect("user/login.html");
			return new Result<User>(true, "微信绑定成功", "1");
		}
	}
	
	@RequestMapping(value="/wechatUnbind",method=RequestMethod.POST)
	@ResponseBody
	public Result wechatUnbind(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String openid =  (String) request.getSession().getAttribute("openid");
		User user =  (User) request.getSession().getAttribute("user");
		if(StringUtils.isBlank(openid)||user==null){
			return new Result<>(false,ErrorCodeConstant.E00009.getMessage(),ErrorCodeConstant.E00009.getCode());
		}else{
			userService.wechatUnbind(user);
			//response.sendRedirect("user/login.html");
			return new Result<User>(true, "微信解绑成功", "1");
		}
	}
	
	@RequestMapping(value="/checkIsWechatLogin",method=RequestMethod.POST)
	@ResponseBody
	public Result checkIsWechatLogin(HttpServletRequest request){
		String openid =  (String) request.getSession().getAttribute("openid");
		if(StringUtils.isBlank(openid)){
			return new Result<>(false,ErrorCodeConstant.E00009.getMessage(),ErrorCodeConstant.E00009.getCode());
		}else{
			return new Result<User>(true, "微信用户已登录", "1");
		}
	}
	
	@RequestMapping(value="/checkIsUserLogin",method=RequestMethod.GET)
	@ResponseBody
	public Result checkIsLogin(HttpServletRequest request){
		User user =  (User) request.getSession().getAttribute("user");
		if(user==null){
			return new Result<>(false,ErrorCodeConstant.E00013.getMessage(),ErrorCodeConstant.E00013.getCode());
		}else{
			return new Result<User>(true, "用户已登录", "1");
		}
	}
	
	
	@RequestMapping(value="/checkWechatAndLogin",method=RequestMethod.GET)
	@ResponseBody
	public Result checkWechatIsBind(HttpServletRequest request){
		Map<String, Object> data  =  new HashMap<String, Object>();
		
	
		User user =  (User) request.getSession().getAttribute("user");
		if(user==null){
			data.put("isLogin", false);
			data.put("isWechatLogin", false);
			data.put("isWechatBind", false);
			return new Result<>(false,data,ErrorCodeConstant.E00013.getMessage(),ErrorCodeConstant.E00013.getCode());
		}else{
			data.put("isLogin", true);
			String openid =  (String) request.getSession().getAttribute("openid");
			if(StringUtils.isBlank(openid)){
				data.put("isWechatLogin", false);
			}else{
				data.put("isWechatLogin", true);
			}
			
			
			String wechatId = user.getWechatId();
			if(StringUtils.isBlank(wechatId)){
				data.put("isWechatBind", false);
			}else{
				data.put("isWechatBind", true);
			}
			return new Result<>(true,data,"用户已经登录","1");
		}

	}
	
}
