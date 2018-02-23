package com.way.waybillsystem.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.Waybill;
import com.way.waybillsystem.service.IWaybillService;
import com.way.waybillsystem.vo.QueryByPageObject;


@Controller
/*public class WaybillAction extends BaseAction {*/
public class WaybillAction  extends BaseAction {
	@Autowired
	private IWaybillService waybillService;
	
	@RequestMapping(value="/insertWaybill",method=RequestMethod.POST)
	@ResponseBody
	public void insertWaybill(Waybill waybill){
		waybillService.insertWaybill(waybill);
	}
	
	@RequestMapping(value="/deleteWaybillByPrimaryKey",method=RequestMethod.POST)
	@ResponseBody
	public void deleteWaybillByPrimaryKey(Long id){
		waybillService.deleteWaybillByPrimaryKey(id);
	}
	
	@RequestMapping(value="/updateWaybillByPrimarykey",method=RequestMethod.POST)
	@ResponseBody
	public void updateWaybillByPrimarykey(Waybill waybill){
		waybillService.updateWaybillByPrimarykey(waybill);
	}
	
	@RequestMapping(value="/selectAllWaybills",method=RequestMethod.GET)
	@ResponseBody
	public List<Waybill> selectAllWaybills(){
		return waybillService.selectAllWaybills();
	}

	
	@RequestMapping(value="/selectWaybillByPrimaryKey",method=RequestMethod.GET)
	@ResponseBody
	public Waybill selectWaybillByPrimaryKey(Long id){
		return waybillService.selectWaybillByPrimaryKey(id);
	}
	
	@RequestMapping(value="/selectAllWaybillsByPage",method=RequestMethod.GET)
	@ResponseBody
	public PageInfo<Waybill> selectAllWaybillsByPage(QueryByPageObject queryObject){
		return waybillService.selectAllWaybillsByPage(queryObject);
	}
}
