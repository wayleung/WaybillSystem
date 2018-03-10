package com.way.waybillsystem.serviceImpl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.Employee;
import com.way.waybillsystem.entity.EmployeeExample;
import com.way.waybillsystem.mapper.EmployeeMapper;
import com.way.waybillsystem.service.IEmployeeService;
import com.way.waybillsystem.vo.QueryByPageObject;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private EmployeeMapper employeeMapper;
	
	private Logger Logger = LoggerFactory.getLogger(EmployeeMapper.class);
	
	@Override
	@Transactional
	public int insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employee.setCreateTime(new Date());
		return employeeMapper.insertSelective(employee);
	}

	@Override
	@Transactional
	public int deleteEmployeeByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return employeeMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional
	public int updateEmployeeByPrimarykey(Employee employee) {
		// TODO Auto-generated method stub
		return employeeMapper.updateByPrimaryKeySelective(employee);
	}

	@Override
	public Employee selectEmployeeByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return employeeMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Employee> selectAllEmployees() {
		// TODO Auto-generated method stub
		EmployeeExample example = new EmployeeExample();
		return employeeMapper.selectByExample(example);
	}

	@Override
	public PageInfo<Employee> selectAllEmployeesByPage(QueryByPageObject queryObject) {
		// TODO Auto-generated method stub
		PageHelper.startPage(queryObject.getCurrentPage(), queryObject.getPageSize());
		//pagehelper不是内存分页是物理分页 PageHelper只对紧跟着的第一个SQL语句起作用
		EmployeeExample example = new EmployeeExample();
		List<Employee> list =  employeeMapper.selectByExample(example);
		PageInfo<Employee> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

}
