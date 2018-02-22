package com.way.waybillsystem.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.WaybillStatus;
import com.way.waybillsystem.service.IWaybillStatusService;
import com.way.waybillsystem.vo.QueryByPageObject;


@Controller
/*public class WaybillStatusAction extends BaseAction {*/
public class WaybillStatusAction {
	@Autowired
	private IWaybillStatusService waybillStatusService;
	
	@RequestMapping(value="/insertWaybillStatus",method=RequestMethod.POST)
	@ResponseBody
	public void insertWaybillStatus(WaybillStatus waybillStatus){
		waybillStatusService.insertWaybillStatus(waybillStatus);
	}
	
	@RequestMapping(value="/deleteWaybillStatusByPrimaryKey",method=RequestMethod.POST)
	@ResponseBody
	public void deleteWaybillStatusByPrimaryKey(Long id){
		waybillStatusService.deleteWaybillStatusByPrimaryKey(id);
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
	public WaybillStatus selectWaybillStatusByPrimaryKey(Long id){
		return waybillStatusService.selectWaybillStatusByPrimaryKey(id);
	}
	
	@RequestMapping(value="/selectAllWaybillStatussByPage",method=RequestMethod.GET)
	@ResponseBody
	public PageInfo<WaybillStatus> selectAllWaybillStatussByPage(QueryByPageObject queryObject){
		return waybillStatusService.selectAllWaybillStatussByPage(queryObject);
	}
}
