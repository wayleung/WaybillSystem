package com.way.waybillsystem.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.Employee;
import com.way.waybillsystem.entity.Location;
import com.way.waybillsystem.entity.Status;
import com.way.waybillsystem.entity.Waybill;
import com.way.waybillsystem.entity.WaybillStatus;
import com.way.waybillsystem.service.IEmployeeService;
import com.way.waybillsystem.service.ILocationService;
import com.way.waybillsystem.service.IStatusService;
import com.way.waybillsystem.service.IWaybillStatusService;
import com.way.waybillsystem.vo.QueryByPageObject;
import com.way.waybillsystem.vo.Result;
import com.way.waybillsystem.vo.WaybillStatusRtnVO;


@Controller
/*public class WaybillStatusAction extends BaseAction {*/
public class WaybillStatusAction  extends BaseAction {
	@Autowired
	private IWaybillStatusService waybillStatusService;
	
	@Autowired
	private ILocationService locationService;

	@Autowired
	private IStatusService statusService;
	
	@Autowired
	private IEmployeeService employeeService;
	
	@RequestMapping(value="/insertWaybillStatus",method=RequestMethod.POST)
	@ResponseBody
	public void insertWaybillStatus(WaybillStatus waybillStatus){
		waybillStatusService.insertWaybillStatus(waybillStatus);
	}
	
	@RequestMapping(value="/deleteWaybillStatusByPrimaryKey",method=RequestMethod.POST)
	@ResponseBody
	public void deleteWaybillStatusByPrimaryKey(Long wsId){
		waybillStatusService.deleteWaybillStatusByPrimaryKey(wsId);
	}
	
	@RequestMapping(value="/updateWaybillStatusByPrimarykey",method=RequestMethod.POST)
	@ResponseBody
	public void updateWaybillStatusByPrimarykey(WaybillStatus waybillStatus){
		waybillStatusService.updateWaybillStatusByPrimarykey(waybillStatus);
	}
	
	@RequestMapping(value="/selectAllWaybillStatuss",method=RequestMethod.GET)
	@ResponseBody
	public List<WaybillStatus> selectAllWaybillStatuss(){
		return waybillStatusService.selectAllWaybillStatuss();
	}

	
	@RequestMapping(value="/selectWaybillStatusByPrimaryKey",method=RequestMethod.GET)
	@ResponseBody
	public WaybillStatus selectWaybillStatusByPrimaryKey(Long wsId){
		return waybillStatusService.selectWaybillStatusByPrimaryKey(wsId);
	}
	
	@RequestMapping(value="/selectAllWaybillStatussByPage",method=RequestMethod.GET)
	@ResponseBody
	public PageInfo<WaybillStatus> selectAllWaybillStatussByPage(QueryByPageObject queryObject){
		return waybillStatusService.selectAllWaybillStatussByPage(queryObject);
	}
	
	@RequestMapping(value="/selectWaybillStatusByWaybillNumber",method=RequestMethod.GET)
	@ResponseBody
	public Result<List<WaybillStatusRtnVO>> selectWaybillStatusByWaybillNumber(Long waybillNumber){
		List<WaybillStatus> waybillstatuss = waybillStatusService.selectWaybillStatusByWaybillNumber(waybillNumber);
		List<WaybillStatusRtnVO> datas = new ArrayList<>();
		
		for (WaybillStatus waybillStatus : waybillstatuss) {
			WaybillStatusRtnVO waybillStatusRtnVO = new WaybillStatusRtnVO();
			waybillStatusRtnVO.setWsId(waybillStatus.getWsId());
			waybillStatusRtnVO.setWaybillNumber(waybillStatus.getWaybillNumber());
			waybillStatusRtnVO.setLacationTime(waybillStatus.getLacationTime());
			
			Long employeeCharge = waybillStatus.getEmployeeCharge();
			Integer locationNow = waybillStatus.getLocationNow();
			Integer status = waybillStatus.getStatus();
			if(employeeCharge!=null&&!employeeCharge.equals("")){
				Employee employee = employeeService.selectEmployeeByPrimaryKey(employeeCharge);
				if(employee!=null){
					waybillStatusRtnVO.setName(employee.getName());
				}
			}
			if(locationNow!=null&&!locationNow.equals("")){
				Location location = locationService.selectLocationByPrimaryKey(locationNow);
				if(location!=null){
					waybillStatusRtnVO.setLocationName(location.getLocationName());
				}
			}
			
			if(status!=null&&!status.equals("")){
				Status statusByPrimaryKey = statusService.selectStatusByPrimaryKey(status);
				if(statusByPrimaryKey!=null){
					waybillStatusRtnVO.setStatusName(statusByPrimaryKey.getStatusName());
				}
			}
			datas.add(waybillStatusRtnVO);
		}
		return new Result<List<WaybillStatusRtnVO>>(true, datas, "查询WaybillStatus表成功！", "1");
	}
}
