package com.way.waybillsystem.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.Fee;
import com.way.waybillsystem.service.IFeeService;
import com.way.waybillsystem.vo.FeeRtnVO;
import com.way.waybillsystem.vo.QueryByPageObject;
import com.way.waybillsystem.vo.Result;


@Controller
public class FeeAction extends BaseAction {
	@Autowired
	IFeeService feeService;
	
	@RequestMapping(value="/insertFee",method=RequestMethod.POST)
	@ResponseBody
	public Result insertFee(Fee fee){
		selectFeeFromTwoArea(fee.getLocationSend(), fee.getLocationReceive());
		FeeRtnVO datas = feeService.selectFeeFromTwoArea(fee.getLocationSend(),fee.getLocationReceive());
		if(datas==null){
			feeService.insertFee(fee);
			return new Result<FeeRtnVO>(true, datas, "插入成功", "1");
		}else{
			return new Result(false, "插入失败 已存在该区间运费信息", "0");
		}
		
	}
	
	
	
	
	
	@RequestMapping(value="/deleteFeeByPrimaryKey",method=RequestMethod.POST)
	@ResponseBody
	public void deleteFeeByPrimaryKey(Integer feeId){
		feeService.deleteFeeByPrimaryKey(feeId);
	}
	
	
	@RequestMapping(value="/updateFeeByPrimarykey",method=RequestMethod.POST)
	@ResponseBody
	public void updateFeeByPrimarykey(Fee fee){
		feeService.updateFeeByPrimarykey(fee);
	}
	
	
	
	@RequestMapping(value="/selectAllFees",method=RequestMethod.GET)
	@ResponseBody
	public Result selectAllFees(){
		List<FeeRtnVO> datas = feeService.selectAllFees();
		if(datas!=null&&datas.size()>0){
			return new Result<List<FeeRtnVO>>(true, datas, "查询Fee表成功！", "1");
		}else{
			return new Result(false, "查询成功 但没有数据", "0");
		}
	}
	
	
/*	@RequestMapping(value="/selectAllFees",method=RequestMethod.GET)
	@ResponseBody
	public Result<PageInfo<Fee>> selectAllFees(QueryByPageObject queryObject){
		PageInfo<Fee> data = feeService.selectAllFeesByPage(queryObject);
			return new  Result<PageInfo<Fee>>(true,data, "查询Fee表成功", "1");
	}*/
	
	
	
	@RequestMapping(value="/selectFeeByIdList",method=RequestMethod.GET)
	@ResponseBody
	public Result<List<FeeRtnVO>> selectFeeByIdList(Integer feeId){
		List<FeeRtnVO> list = feeService.selectFeeByIdList(feeId);
		
		if(list!=null&&list.size()>0){
			return new Result<List<FeeRtnVO>>(true, list, "查询Fee表成功！", "1");
		}else{
			return new Result(false, "查询成功 但没有数据", "0");
		}
	}
	
	
	
	
	@RequestMapping(value="/selectFeeFromTwoArea",method=RequestMethod.GET)
	@ResponseBody
	public Result selectFeeFromTwoArea(Integer locationSend,Integer locationReceive){
		FeeRtnVO datas = feeService.selectFeeFromTwoArea(locationSend,locationReceive);
		if(datas!=null){
			return new Result<FeeRtnVO>(true, datas, "查询Fee表成功 查询两区间的运费信息成功！", "1");
		}else{
			return new Result(false, "没有两区间的运费信息", "0");
		}
	}
	
	
}
