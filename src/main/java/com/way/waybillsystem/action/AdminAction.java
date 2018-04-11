package com.way.waybillsystem.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.Admin;
import com.way.waybillsystem.entity.Employee;
import com.way.waybillsystem.entity.Message;
import com.way.waybillsystem.exception.ErrorCodeConstant;
import com.way.waybillsystem.service.IAdminService;
import com.way.waybillsystem.service.IMessageService;
import com.way.waybillsystem.vo.AdminLoginVO;
import com.way.waybillsystem.vo.QueryByPageObject;
import com.way.waybillsystem.vo.Result;


@Controller
/*public class AdminAction extends BaseAction {*/
public class AdminAction extends BaseAction {
	@Autowired
	private IAdminService adminService;
	
	@Autowired
	private IMessageService messageService;
	
	@RequestMapping(value="/insertAdmin",method=RequestMethod.POST)
	@ResponseBody
	public void insertAdmin(Admin admin){
		adminService.insertAdmin(admin);
	}
	
	@RequestMapping(value="/deleteAdminByPrimaryKey",method=RequestMethod.POST)
	@ResponseBody
	public void deleteAdminByPrimaryKey(Integer id){
		adminService.deleteAdminByPrimaryKey(id);
	}
	
	@RequestMapping(value="/updateAdminByPrimarykey",method=RequestMethod.POST)
	@ResponseBody
	public void updateAdminByPrimarykey(Admin admin){
		adminService.updateAdminByPrimarykey(admin);
	}
	
	@RequestMapping(value="/selectAllAdmins",method=RequestMethod.GET)
	@ResponseBody
	public List<Admin> selectAllAdmins(){
		return adminService.selectAllAdmins();
	}

	
	@RequestMapping(value="/selectAdminByPrimaryKey",method=RequestMethod.GET)
	@ResponseBody
	public Admin selectAdminByPrimaryKey(Integer id){
		return adminService.selectAdminByPrimaryKey(id);
	}
	
	@RequestMapping(value="/selectAllAdminsByPage",method=RequestMethod.GET)
	@ResponseBody
	public PageInfo<Admin> selectAllAdminsByPage(QueryByPageObject queryObject){
		return adminService.selectAllAdminsByPage(queryObject);
	}
	
	
	@RequestMapping(value="/AdminLogin",method=RequestMethod.POST)
	@ResponseBody
	public Result<Admin> AdminLogin(AdminLoginVO loginVO){
		String account = loginVO.getAccount();
		String password = loginVO.getPassword();
		String verifyCode = loginVO.getVerifyCode();
/*		Checks if a String is whitespace, empty ("") or null.
		 StringUtils.isBlank(null)      = true
		 StringUtils.isBlank("")        = true
		 StringUtils.isBlank(" ")       = true
		 StringUtils.isBlank("bob")     = false
		 StringUtils.isBlank("  bob  ") = false*/

		if(StringUtils.isBlank(account)||StringUtils.isBlank(password)||StringUtils.isBlank(verifyCode)){
			return new Result<>(false,ErrorCodeConstant.E00003.getMessage(),ErrorCodeConstant.E00003.getCode());
		}
		return null;
	}
	
	@RequestMapping(value="/selectAllMessages",method=RequestMethod.GET)
	@ResponseBody
	public  Result<List<Message>> selectAllMessages(){
		List<Message> data = messageService.selectAllMessages();
		return new Result<List<Message>>(true, data, "查询Message表成功！", "1");
	}
	
	
	@RequestMapping(value="/deleteMessageByPrimaryKey",method=RequestMethod.GET)
	@ResponseBody
	public void deleteMessageByPrimaryKey(Integer messageId){
		messageService.deleteMessageByPrimaryKey(messageId);
	}
	
}
