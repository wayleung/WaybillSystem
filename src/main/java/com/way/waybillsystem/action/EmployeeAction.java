package com.way.waybillsystem.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.Employee;
import com.way.waybillsystem.entity.User;
import com.way.waybillsystem.service.IEmployeeService;
import com.way.waybillsystem.vo.FeeRtnVO;
import com.way.waybillsystem.vo.QueryByPageObject;
import com.way.waybillsystem.vo.Result;


@Controller
/*public class EmployeeAction extends BaseAction {*/
public class EmployeeAction  extends BaseAction {
	@Autowired
	private IEmployeeService employeeService;
	
	@RequestMapping(value="/insertEmployee",method=RequestMethod.POST)
	@ResponseBody
	public void insertEmployee(Employee employee){
		employeeService.insertEmployee(employee);
	}
	
	@RequestMapping(value="/deleteEmployeeByPrimaryKey",method=RequestMethod.POST)
	@ResponseBody
	public void deleteEmployeeByPrimaryKey(Long id){
		employeeService.deleteEmployeeByPrimaryKey(id);
	}
	
	@RequestMapping(value="/updateEmployeeByPrimarykey",method=RequestMethod.POST)
	@ResponseBody
	public void updateEmployeeByPrimarykey(Employee employee){
		employeeService.updateEmployeeByPrimarykey(employee);
	}
	
/*	@RequestMapping(value="/selectAllEmployees",method=RequestMethod.GET)
	@ResponseBody
	public Result<List<Employee>> selectAllEmployees(){
		return employeeService.selectAllEmployees();
		List<Employee> data = employeeService.selectAllEmployees();
		return new Result<List<Employee>>(true, data, "查询Employees表成功！", "1");
	}*/
	
	
	@RequestMapping(value="/selectAllEmployees",method=RequestMethod.GET)
	@ResponseBody
	public Result<PageInfo<Employee>> selectAllEmployees(QueryByPageObject queryObject){
		/*return employeeService.selectAllEmployees();*/
		PageInfo<Employee> data = employeeService.selectAllEmployeesByPage(queryObject);
		return new Result<PageInfo<Employee>>(true, data, "查询Employees表成功！", "1");
	}
	
	
	 

	
	@RequestMapping(value="/selectEmployeeByPrimaryKey",method=RequestMethod.GET)
	@ResponseBody
	public Employee selectEmployeeByPrimaryKey(Long id){
		return employeeService.selectEmployeeByPrimaryKey(id);
	}
	
	@RequestMapping(value="/selectEmployeeByPrimaryKeyList",method=RequestMethod.GET)
	@ResponseBody
	public Result<List<Employee>> selectEmployeeByPrimaryKeyList(Long id){
		Employee employee = employeeService.selectEmployeeByPrimaryKey(id);
		if(employee!=null){
			List<Employee> list = new ArrayList<>();
			list.add(employee);
			return new Result<List<Employee>>(true, list, "查询Employee表成功！", "1");
		}else{
			return new Result(false, "查询成功 但没有数据", "0");
		}
		
		

	}
	
	
	@RequestMapping(value="/selectAllEmployeesByPage",method=RequestMethod.GET)
	@ResponseBody
	public PageInfo<Employee> selectAllEmployeesByPage(QueryByPageObject queryObject){
		return employeeService.selectAllEmployeesByPage(queryObject);
	}
}
