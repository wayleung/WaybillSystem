package com.way.waybillsystem.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.Fee;
import com.way.waybillsystem.entity.FeeExample;
import com.way.waybillsystem.entity.FeeExample.Criteria;
import com.way.waybillsystem.entity.Location;
import com.way.waybillsystem.mapper.FeeMapper;
import com.way.waybillsystem.mapper.LocationMapper;
import com.way.waybillsystem.service.IFeeService;
import com.way.waybillsystem.vo.FeeRtnVO;
import com.way.waybillsystem.vo.QueryByPageObject;
import com.way.waybillsystem.vo.Result;

@Service
public class FeeServiceImpl implements IFeeService {
	@Autowired
	private FeeMapper feeMapper;
	
	@Autowired
	private LocationMapper locationMapper;
	
	private Logger Logger = LoggerFactory.getLogger(FeeServiceImpl.class);
	
	@Override
	@Transactional
	public int insertFee(Fee fee) {
		// TODO Auto-generated method stub
		return feeMapper.insertSelective(fee);
	}

	@Override
	@Transactional
	public int deleteFeeByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return feeMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional
	public int updateFeeByPrimarykey(Fee fee) {
		// TODO Auto-generated method stub
		return feeMapper.updateByPrimaryKeySelective(fee);
	}

	@Override
	public Fee selectFeeByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return feeMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<FeeRtnVO> selectAllFees() {
		// TODO Auto-generated method stub
		FeeExample example = new FeeExample();
		
		List<FeeRtnVO> volist = new ArrayList<>();
		List<Fee> list = feeMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			for (Fee fee : list) {
				FeeRtnVO feeRtnVO = new FeeRtnVO();
				feeRtnVO.setLocationSend(fee.getLocationSend());
				Location location_send = locationMapper.selectByPrimaryKey(fee.getLocationSend());
				feeRtnVO.setLocationSendName(location_send.getLocationName());
				feeRtnVO.setLocationReceive(fee.getLocationReceive());
				Location location_receive = locationMapper.selectByPrimaryKey(fee.getLocationReceive());
				feeRtnVO.setLocationReceiveName(location_receive.getLocationName());
				feeRtnVO.setFeeId(fee.getFeeId());
				feeRtnVO.setFee(fee.getFee());
				volist.add(feeRtnVO);
			}
			
			return volist;
		}else{
			return null;
		}
	}

	@Override
	public PageInfo<Fee> selectAllFeesByPage(QueryByPageObject queryObject) {
		// TODO Auto-generated method stub
		PageHelper.startPage(queryObject.getCurrentPage(), queryObject.getPageSize());
		//pagehelper不是内存分页是物理分页 PageHelper只对紧跟着的第一个SQL语句起作用
		FeeExample example = new FeeExample();
		List<Fee> list =  feeMapper.selectByExample(example);
		PageInfo<Fee> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public FeeRtnVO selectFeeFromTwoArea(Integer locationSend,Integer locationReceive) {
		// TODO Auto-generated method stub
		
		//System.out.println("-----"+locationSend+locationReceive);
		FeeExample example = new FeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andLocationSendEqualTo(locationSend);
		criteria.andLocationReceiveEqualTo(locationReceive);
		List<Fee> list = feeMapper.selectByExample(example);

		if(list!=null&&list.size()>0){
			Fee fee = list.get(0);
				FeeRtnVO feeRtnVO = new FeeRtnVO();
				feeRtnVO.setLocationSend(fee.getLocationSend());
				Location location_send = locationMapper.selectByPrimaryKey(fee.getLocationSend());
				feeRtnVO.setLocationSendName(location_send.getLocationName());
				feeRtnVO.setLocationReceive(fee.getLocationReceive());
				Location location_receive = locationMapper.selectByPrimaryKey(fee.getLocationReceive());
				feeRtnVO.setLocationReceiveName(location_receive.getLocationName());
				feeRtnVO.setFeeId(fee.getFeeId());
				feeRtnVO.setFee(fee.getFee());
			
			
			return feeRtnVO;
		}else{
			return null;
		}
	}

	@Override
	public List<FeeRtnVO> selectFeeByIdList(Integer feeId) {
		// TODO Auto-generated method stub
		List<FeeRtnVO> list = new ArrayList<>();
		Fee fee = selectFeeByPrimaryKey(feeId);
		
		if(fee!=null){
			
			FeeRtnVO feeRtnVO = new FeeRtnVO();
			feeRtnVO.setLocationSend(fee.getLocationSend());
			Location location_send = locationMapper.selectByPrimaryKey(fee.getLocationSend());
			feeRtnVO.setLocationSendName(location_send.getLocationName());
			feeRtnVO.setLocationReceive(fee.getLocationReceive());
			Location location_receive = locationMapper.selectByPrimaryKey(fee.getLocationReceive());
			feeRtnVO.setLocationReceiveName(location_receive.getLocationName());
			feeRtnVO.setFeeId(fee.getFeeId());
			feeRtnVO.setFee(fee.getFee());
			
			list.add(feeRtnVO);
			return list;
		}else{
			return null;
		}
	}

}
