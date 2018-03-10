package com.way.waybillsystem.action;

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
	
	@RequestMapping(value="/selectAllEmployees",method=RequestMethod.GET)
	@ResponseBody
	public Result<List<Employee>> selectAllEmployees(){
		/*return employeeService.selectAllEmployees();*/
		List<Employee> data = employeeService.selectAllEmployees();
		return new Result<List<Employee>>(true, data, "查询Employees表成功！", "1");
	}

	
	@RequestMapping(value="/selectEmployeeByPrimaryKey",method=RequestMethod.GET)
	@ResponseBody
	public Employee selectEmployeeByPrimaryKey(Long id){
		return employeeService.selectEmployeeByPrimaryKey(id);
	}
	
	@RequestMapping(value="/selectAllEmployeesByPage",method=RequestMethod.GET)
	@ResponseBody
	public PageInfo<Employee> selectAllEmployeesByPage(QueryByPageObject queryObject){
		return employeeService.selectAllEmployeesByPage(queryObject);
	}
}
