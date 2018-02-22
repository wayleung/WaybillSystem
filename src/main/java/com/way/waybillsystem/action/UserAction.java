package com.way.waybillsystem.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.User;
import com.way.waybillsystem.service.IUserService;
import com.way.waybillsystem.vo.QueryByPageObject;


@Controller
/*public class UserAction extends BaseAction {*/
public class UserAction {
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
	public List<User> selectAllUsers(){
		return userService.selectAllUsers();
	}

	
	@RequestMapping(value="/selectUserByPrimaryKey",method=RequestMethod.GET)
	@ResponseBody
	public User selectUserByPrimaryKey(Long id){
		return userService.selectUserByPrimaryKey(id);
	}
	
	@RequestMapping(value="/selectAllUsersByPage",method=RequestMethod.GET)
	@ResponseBody
	public PageInfo<User> selectAllUsersByPage(QueryByPageObject queryObject){
		return userService.selectAllUsersByPage(queryObject);
	}
}
