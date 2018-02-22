package com.way.waybillsystem.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.PayOption;
import com.way.waybillsystem.vo.QueryByPageObject;

/**
 * 
* @author Way Leung
* @Description: TODO(用一句话描述该文件做什么)   
* @date 2018年2月17日
 */


public interface IPayOptionService {
	int insertPayOption(PayOption payoption);
	
	int deletePayOptionByPrimaryKey(Integer id);
	
	int updatePayOptionByPrimarykey(PayOption payoption);
	
	PayOption selectPayOptionByPrimaryKey(Integer id);
	
	List<PayOption> selectAllPayOptions();
	
	PageInfo<PayOption> selectAllPayOptionsByPage(QueryByPageObject queryObject);
	
}
