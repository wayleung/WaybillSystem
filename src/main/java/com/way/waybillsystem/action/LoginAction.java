package com.way.waybillsystem.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.way.waybillsystem.entity.Admin;
import com.way.waybillsystem.entity.User;
import com.way.waybillsystem.exception.ErrorCodeConstant;
import com.way.waybillsystem.service.IAdminService;
import com.way.waybillsystem.service.IUserService;
import com.way.waybillsystem.util.MD5Util;
import com.way.waybillsystem.vo.AdminLoginVO;
import com.way.waybillsystem.vo.QueryByPageObject;
import com.way.waybillsystem.vo.Result;
import com.way.waybillsystem.vo.UserLoginVO;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


@Controller
/*public class AdminAction extends BaseAction {*/
public class LoginAction extends BaseAction {
	@Autowired
	private IAdminService adminService;
	
	
	@Autowired
	private IUserService userService;
	

	
	
	@RequestMapping(value="/adminLogin",method=RequestMethod.GET)
	@ResponseBody
	public Result<Admin> adminLogin(HttpServletRequest request,HttpServletResponse response,AdminLoginVO loginVO) throws IOException{
		String account = loginVO.getAccount();
		String password = loginVO.getPassword();
		String verifyCode = loginVO.getVerifyCode();

		//md5加密
		password = MD5Util.EncoderByMd5(password);

		if(StringUtils.isBlank(account)||StringUtils.isBlank(password)||StringUtils.isBlank(verifyCode)){
			return new Result<>(false,ErrorCodeConstant.E00003.getMessage(),ErrorCodeConstant.E00003.getCode());
		}
		
		
		String verifyCode_server =  (String) request.getSession().getAttribute("verifyCode");
		if(!verifyCode.equals(verifyCode_server)){
			return new Result<>(false,ErrorCodeConstant.E00001.getMessage(),ErrorCodeConstant.E00001.getCode());
		}
		
		Admin admin = adminService.selectAdminByAccount(account);
		if(admin==null){
			return new Result<>(false,ErrorCodeConstant.E00004.getMessage(),ErrorCodeConstant.E00004.getCode());
		}
		if(!admin.getPassword().equals(password))
		{
			return new Result<>(false,ErrorCodeConstant.E00004.getMessage(),ErrorCodeConstant.E00004.getCode());
		}else{
			//把登录成功用户信息存session
			request.getSession().setAttribute("admin", admin);
			return new Result<Admin>(true, admin, ErrorCodeConstant.E00000.getMessage(), ErrorCodeConstant.E00000.getCode());
		}
	}
	

	
	
	
	@RequestMapping(value="/adminLogout",method=RequestMethod.GET)
	@ResponseBody
	public void adminLogout(HttpServletRequest request,HttpServletResponse response) throws IOException{
		request.getSession().setAttribute("admin", null);
		response.sendRedirect("admin/login.html");
	}
	
	
	
	@RequestMapping(value="/userLogin",method=RequestMethod.GET)
	@ResponseBody
	public Result userLogin(HttpServletRequest request,HttpServletResponse response,UserLoginVO loginVO) throws IOException{
		String account = loginVO.getAccount();
		String password = loginVO.getPassword();
		String verifyCode = loginVO.getVerifyCode();

		
		//md5加密
		password = MD5Util.EncoderByMd5(password);

		if(StringUtils.isBlank(account)||StringUtils.isBlank(password)||StringUtils.isBlank(verifyCode)){
			return new Result<>(false,ErrorCodeConstant.E00003.getMessage(),ErrorCodeConstant.E00003.getCode());
		}
		
		
		String verifyCode_server =  (String) request.getSession().getAttribute("verifyCode");
		if(!verifyCode.equals(verifyCode_server)){
			return new Result<>(false,ErrorCodeConstant.E00001.getMessage(),ErrorCodeConstant.E00001.getCode());
		}
		
		User user = userService.selectUserByAccount(account);
		if(user==null){
			return new Result<>(false,ErrorCodeConstant.E00004.getMessage(),ErrorCodeConstant.E00004.getCode());
		}
		if(!user.getPassword().equals(password))
		{
			return new Result<>(false,ErrorCodeConstant.E00004.getMessage(),ErrorCodeConstant.E00004.getCode());
		}else{
			//把登录成功用户信息存session
			request.getSession().setAttribute("user", user);
			return new Result<User>(true, user, ErrorCodeConstant.E00000.getMessage(), ErrorCodeConstant.E00000.getCode());
		}
	}
	
	@RequestMapping(value="/userLogout",method=RequestMethod.GET)
	@ResponseBody
	public void userLogout(HttpServletRequest request,HttpServletResponse response) throws IOException{
		request.getSession().setAttribute("user", null);
		response.sendRedirect("user/login.html");
	}

	
	@RequestMapping(value="/userRegister",method=RequestMethod.GET)
	@ResponseBody
	public Result userRegister(HttpServletRequest request,HttpServletResponse response,UserLoginVO loginVO){
		String account = loginVO.getAccount();
		String password = loginVO.getPassword();
		String verifyCode = loginVO.getVerifyCode();
		if(StringUtils.isBlank(account)||StringUtils.isBlank(password)||StringUtils.isBlank(verifyCode)){
			return new Result<>(false,ErrorCodeConstant.E00003.getMessage(),ErrorCodeConstant.E00003.getCode());
		}
		String verifyCode_server =  (String) request.getSession().getAttribute("verifyCode");
		if(!verifyCode.equals(verifyCode_server)){
			return new Result<>(false,ErrorCodeConstant.E00001.getMessage(),ErrorCodeConstant.E00001.getCode());
		}
		User user = userService.selectUserByAccount(account);
		if(user!=null){
			return new Result<>(false,ErrorCodeConstant.E00011.getMessage(),ErrorCodeConstant.E00011.getCode());
		}else{
			User user_new =  new User();
			user_new.setAccount(account);
			
			//md5加密
			password = MD5Util.EncoderByMd5(password);
			
			user_new.setPassword(password);
			//新增注册用户到数据库
			userService.insertUser(user_new);
			//user存进数据库后 要再查询一遍把id获取并存进session 否则 session里面的user没有session
			User user_new_select = userService.selectUserByAccount(account);
			
			//把登录成功用户信息存session
			//request.getSession().setAttribute("user", user_new);
			request.getSession().setAttribute("user", user_new_select);
			return new Result<User>(true, user_new, ErrorCodeConstant.E00000.getMessage(), ErrorCodeConstant.E00000.getCode());
		}
	}
	

	
	
	
	
    @RequestMapping(value="/authCode")
    public void getAuthCode(HttpServletRequest request, HttpServletResponse response,HttpSession session)
            throws IOException {
        int width = 63;
        int height = 37;
        Random random = new Random();
        //设置response头信息
        //禁止缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        //生成缓冲区image类
        BufferedImage image = new BufferedImage(width, height, 1);
        //产生image类的Graphics用于绘制操作
        Graphics g = image.getGraphics();
        //Graphics类的样式
        g.setColor(this.getRandColor(200, 250));
        g.setFont(new Font("Times New Roman",0,28));
        g.fillRect(0, 0, width, height);
        //绘制干扰线
        for(int i=0;i<40;i++){
            g.setColor(this.getRandColor(130, 200));
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            g.drawLine(x, y, x + x1, y + y1);
        }

        //绘制字符
        String verifyCode = "";
        for(int i=0;i<4;i++){
            String rand = String.valueOf(random.nextInt(10));
            verifyCode = verifyCode + rand;
            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            g.drawString(rand, 13*i+6, 28);
        }
        //将字符保存到session中用于前端的验证
        session.setAttribute("verifyCode", verifyCode);
        
        
        g.dispose();

        ImageIO.write(image, "JPEG", response.getOutputStream());
        response.getOutputStream().flush();
    }
    
    //创建颜色
    Color getRandColor(int fc,int bc){
        Random random = new Random();
        if(fc>255)
            fc = 255;
        if(bc>255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r,g,b);
    }
    /**
     * 进行验证用户的验证码是否正确
     * @param value 用户输入的验证码
     * @param request HttpServletRequest对象
     * @return 一个String类型的字符串。格式为：<br/>
     *                     {"res",boolean},<br/>
     *                 如果为{"res",true}，表示验证成功<br/>
     *                 如果为{"res",false}，表示验证失败
     * 
     */
/*    @RequestMapping(value="/validate")
    @ResponseBody
    public String validate(String value,HttpServletRequest request){
        String valueCode=(String)request.getSession().getAttribute("strCode");
        Map map=new HashMap();
        if(valueCode!=null){
            if(valueCode.equals(value)){
                map.put("res", true);
                return new Gson().toJson(map);
            }
        }
        map.put("res", false);
        return new Gson().toJson(map);
    }*/

}
