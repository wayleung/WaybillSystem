package com.way.waybillsystem.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.User;
import com.way.waybillsystem.vo.QueryByPageObject;

/**
 * 
* @author Way Leung
* @Description: TODO(用一句话描述该文件做什么)   
* @date 2018年2月17日
 */


public interface IUserService {
	int insertUser(User user);
	
	int deleteUserByPrimaryKey(Long id);
	
	int updateUserByPrimarykey(User user);
	
	User selectUserByPrimaryKey(Long id);
	
	List<User> selectAllUsers();
	
	PageInfo<User> selectAllUsersByPage(QueryByPageObject queryObject);
	
}
