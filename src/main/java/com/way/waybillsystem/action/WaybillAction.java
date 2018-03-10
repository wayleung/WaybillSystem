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
import com.way.waybillsystem.vo.Result;


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
	public void deleteWaybillByPrimaryKey(Long waybillNumber){
		waybillService.deleteWaybillByPrimaryKey(waybillNumber);
	}
	
	@RequestMapping(value="/updateWaybillByPrimarykey",method=RequestMethod.POST)
	@ResponseBody
	public void updateWaybillByPrimarykey(Waybill waybill){
		waybillService.updateWaybillByPrimarykey(waybill);
	}
	
	@RequestMapping(value="/selectAllWaybills",method=RequestMethod.GET)
	@ResponseBody
	public Result<List<Waybill>> selectAllWaybills(){
		/*return waybillService.selectAllWaybills();*/
		List<Waybill> data = waybillService.selectAllWaybills();
		return new Result<List<Waybill>>(true, data, "查询Waybills表成功！", "1");
	}

	
	@RequestMapping(value="/selectWaybillByPrimaryKey",method=RequestMethod.GET)
	@ResponseBody
	public Waybill selectWaybillByPrimaryKey(Long waybillNumber){
		return waybillService.selectWaybillByPrimaryKey(waybillNumber);
	}
	
	@RequestMapping(value="/selectAllWaybillsByPage",method=RequestMethod.GET)
	@ResponseBody
	public PageInfo<Waybill> selectAllWaybillsByPage(QueryByPageObject queryObject){
		return waybillService.selectAllWaybillsByPage(queryObject);
	}
}
