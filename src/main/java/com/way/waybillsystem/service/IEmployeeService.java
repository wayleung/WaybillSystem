package com.way.waybillsystem.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.Employee;
import com.way.waybillsystem.vo.QueryByPageObject;

/**
 * 
* @author Way Leung
* @Description: TODO(用一句话描述该文件做什么)   
* @date 2018年2月17日
 */
public interface IEmployeeService {
	int insertEmployee(Employee employee);
	
	int deleteEmployeeByPrimaryKey(Long id);
	
	int updateEmployeeByPrimarykey(Employee employee);
	
	Employee selectEmployeeByPrimaryKey(Long id);
	
	List<Employee> selectAllEmployees();
	
	PageInfo<Employee> selectAllEmployeesByPage(QueryByPageObject queryObject);
}
