package com.way.waybillsystem.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.User;
import com.way.waybillsystem.entity.Waybill;
import com.way.waybillsystem.exception.ErrorCodeConstant;
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
	
/*	@RequestMapping(value="/selectWaybillByPrimaryKey",method=RequestMethod.GET)
	@ResponseBody
	public Result<Waybill> selectWaybillByPrimaryKey(Long waybillNumber){
		Waybill data = waybillService.selectWaybillByPrimaryKey(waybillNumber);
		if(data!=null){
			return new Result<Waybill>(true, data, "查询Waybills表成功！", "1");
		}else{
			return new Result<Waybill>(false, null, "Waybills表为空！", "0");
		}
	}*/
	
	@RequestMapping(value="/selectAllWaybillsByPage",method=RequestMethod.GET)
	@ResponseBody
	public PageInfo<Waybill> selectAllWaybillsByPage(QueryByPageObject queryObject){
		return waybillService.selectAllWaybillsByPage(queryObject);
	}
	
	
	
	
	@RequestMapping(value="/selectWaybillByWaybillNumber",method=RequestMethod.GET)
	@ResponseBody
	public Result<Waybill> selectWaybillByWaybillNumber(Long waybillNumber){
		Waybill waybill = waybillService.selectWaybillByWaybillNumber(waybillNumber);
		if(waybill!=null){
			return new Result<Waybill>(true,waybill, "查询物流运单成功", "1");
		}else{
			return new Result(false, "没有该运单号对应运单", "0");
		}
		
	}
	
	//resultjson里面要数组 否则vue接收不到数据
	@RequestMapping(value="/selectWaybillByWaybillNumberList",method=RequestMethod.GET)
	@ResponseBody
	public Result<List<Waybill>> selectWaybillByWaybillNumberList(Long waybillNumber){
		List<Waybill> list = new ArrayList<>();
		Waybill waybill = waybillService.selectWaybillByWaybillNumber(waybillNumber);

		if(waybill!=null){
			list.add(waybill);
			return new Result<List<Waybill>>(true,list, "查询物流运单成功", "1");
		}else{
			return new Result(false, "没有该运单号对应运单", "0");
		}
		
	}
	
	
	@RequestMapping(value="/followWaybill",method=RequestMethod.POST)
	@ResponseBody
	public Result<Waybill> followWaybill(HttpServletRequest request,Long waybillNumber){
		User user = (User) request.getSession().getAttribute("user");
		if(user!=null){
			Long userid = user.getId();
			Waybill waybill = waybillService.selectWaybillByWaybillNumber(waybillNumber);
			if(waybill!=null){
				waybill.setUserId(userid);
				waybillService.updateWaybillByPrimarykey(waybill);
				return new Result<Waybill>(true,waybill, "追踪物流运单成功", "1");
			}else{
				return new Result<Waybill>(false,ErrorCodeConstant.E00015.getMessage(), ErrorCodeConstant.E00015.getCode());
			}
			
		}else{
			return new Result<Waybill>(false,ErrorCodeConstant.E00013.getMessage(), ErrorCodeConstant.E00013.getCode());
		}
		
	}
	
}
