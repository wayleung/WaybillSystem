package com.way.waybillsystem.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.way.waybillsystem.entity.Fee;
import com.way.waybillsystem.service.IFeeService;
import com.way.waybillsystem.vo.FeeRtnVO;
import com.way.waybillsystem.vo.Result;


@Controller
public class FeeAction extends BaseAction {
	@Autowired
	IFeeService feeService;
	
	@RequestMapping(value="/insertFee",method=RequestMethod.POST)
	@ResponseBody
	public void insertFee(Fee fee){
		feeService.insertFee(fee);
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
