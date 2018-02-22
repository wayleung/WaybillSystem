package com.way.waybillsystem.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.Admin;
import com.way.waybillsystem.vo.QueryByPageObject;

/**
 * 
* @author Way Leung
* @Description: TODO(用一句话描述该文件做什么)   
* @date 2018年2月17日
 */


public interface IAdminService {
	int insertAdmin(Admin admin);
	
	int deleteAdminByPrimaryKey(Integer id);
	
	int updateAdminByPrimarykey(Admin admin);
	
	Admin selectAdminByPrimaryKey(Integer id);
	
	List<Admin> selectAllAdmins();
	
	PageInfo<Admin> selectAllAdminsByPage(QueryByPageObject queryObject);
	
}
