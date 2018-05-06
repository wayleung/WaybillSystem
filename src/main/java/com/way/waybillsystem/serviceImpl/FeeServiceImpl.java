package com.way.waybillsystem.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jredis.JredisPool;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mchange.io.SerializableUtils;
import com.way.waybillsystem.entity.Fee;
import com.way.waybillsystem.entity.FeeExample;
import com.way.waybillsystem.entity.FeeExample.Criteria;
import com.way.waybillsystem.entity.Location;
import com.way.waybillsystem.mapper.FeeMapper;
import com.way.waybillsystem.mapper.LocationMapper;
import com.way.waybillsystem.service.IFeeService;
import com.way.waybillsystem.util.SerializeUtil;
import com.way.waybillsystem.vo.FeeRtnVO;
import com.way.waybillsystem.vo.QueryByPageObject;
import com.way.waybillsystem.vo.Result;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Service
public class FeeServiceImpl implements IFeeService {
	@Autowired
	private FeeMapper feeMapper;
	
	@Autowired
	private JedisPool jedisPool;
	
	
	@Autowired
	private LocationMapper locationMapper;
	
	private Logger Logger = LoggerFactory.getLogger(FeeServiceImpl.class);
	
	@Override
	@Transactional
	public int insertFee(Fee fee) {
	//public int insertFee(Fee fee) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		
		//密码验证 使用密码验证 需要在redis客户端使用命令 config set requirepass password 否则没有设置密码 但是auth的话会报错 can not get resource from pool
		String auth = jedis.auth("root");
		System.out.println(auth);
		if(auth.equals("OK")){
			//选一个db专门放Fee
			jedis.select(1);
			Integer send = fee.getLocationSend();
			Integer receive = fee.getLocationReceive();
/*			String id = String.valueOf(send)+String.valueOf(receive);
			Integer id_int = Integer.valueOf(id);
			fee.setFeeId(id_int);	*/
			//制造自增id
			Long dbSize = jedis.dbSize();
			//强制转换 可能有精度损失
			Integer id_int = (int) (dbSize+1);
			fee.setFeeId(id_int);
			String id = String.valueOf(dbSize+1);
			jedis.set(id.getBytes(), SerializeUtil. serialize(fee));
			//持久化
			jedis.persist(id.getBytes());
			return 1;
		}

		return 0;
		
		//return feeMapper.insertSelective(fee);
	}

	@Override
	@Transactional
	public int deleteFeeByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		//return feeMapper.deleteByPrimaryKey(id);
		
		Jedis jedis = jedisPool.getResource();
		
		//密码验证 使用密码验证 需要在redis客户端使用命令 config set requirepass password 否则没有设置密码 但是auth的话会报错 can not get resource from pool
		String auth = jedis.auth("root");
		System.out.println(auth);
		if(auth.equals("OK")){
			//选一个db专门放Fee
			jedis.select(1);
			jedis.del(String.valueOf(id).getBytes());
			return 1;
		}
		
		return 0;
	}

	@Override
	@Transactional
	public int updateFeeByPrimarykey(Fee fee) {
		// TODO Auto-generated method stub
		//return feeMapper.updateByPrimaryKeySelective(fee);
		
		Jedis jedis = jedisPool.getResource();
		Integer id_int = fee.getFeeId();
		//密码验证 使用密码验证 需要在redis客户端使用命令 config set requirepass password 否则没有设置密码 但是auth的话会报错 can not get resource from pool
		String auth = jedis.auth("root");
		System.out.println(auth);
		if(auth.equals("OK")){
			//选一个db专门放Fee
			jedis.select(1);
			
			jedis.set(String.valueOf(id_int).getBytes(), SerializeUtil. serialize(fee));
			//持久化
			jedis.persist(String.valueOf(id_int).getBytes());
			return 1;
		}
		
		return 0;
	}

	@Override
	public Fee selectFeeByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		//return feeMapper.selectByPrimaryKey(id);
		
		
		Jedis jedis = jedisPool.getResource();
		//密码验证 使用密码验证 需要在redis客户端使用命令 config set requirepass password 否则没有设置密码 但是auth的话会报错 can not get resource from pool
		String auth = jedis.auth("root");
		System.out.println(auth);
		if(auth.equals("OK")){
			//选一个db专门放Fee
			jedis.select(1);
			byte[] bs = jedis.get(String.valueOf(id).getBytes());
			Fee fee = (Fee) SerializeUtil.unserialize(bs);
			
			return fee;
		}
		
		return null;
	}

	@Override
	public List<FeeRtnVO> selectAllFees() {
		// TODO Auto-generated method stub
/*		FeeExample example = new FeeExample();
		
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
		*/
		
		Jedis jedis = jedisPool.getResource();
		//密码验证 使用密码验证 需要在redis客户端使用命令 config set requirepass password 否则没有设置密码 但是auth的话会报错 can not get resource from pool
		String auth = jedis.auth("root");
		System.out.println(auth);
		if(auth.equals("OK")){
			List<FeeRtnVO> volist = new ArrayList<>();
			
			
			//选一个db专门放Fee
			jedis.select(1);
			Set<String> keys = jedis.keys("*");
			
			if(keys!=null&&keys.size()>0){
				for (String id : keys) {
					byte[] bs = jedis.get(id.getBytes());
					Fee fee = (Fee) SerializeUtil.unserialize(bs);
					
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
			}

			
		}
		
		return null;
		
	}

	@Override
	public PageInfo<Fee> selectAllFeesByPage(QueryByPageObject queryObject) {
		// TODO Auto-generated method stub
/*		PageHelper.startPage(queryObject.getCurrentPage(), queryObject.getPageSize());*/
		//pagehelper不是内存分页是物理分页 PageHelper只对紧跟着的第一个SQL语句起作用
/*		FeeExample example = new FeeExample();
		List<Fee> list =  feeMapper.selectByExample(example);
		PageInfo<Fee> pageInfo = new PageInfo<>(list);
		return pageInfo;*/
		
		return null;
	}

	@Override
	public FeeRtnVO selectFeeFromTwoArea(Integer locationSend,Integer locationReceive) {
		// TODO Auto-generated method stub
		
		//System.out.println("-----"+locationSend+locationReceive);
/*		FeeExample example = new FeeExample();
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
		}*/
		
		
		Jedis jedis = jedisPool.getResource();
		//密码验证 使用密码验证 需要在redis客户端使用命令 config set requirepass password 否则没有设置密码 但是auth的话会报错 can not get resource from pool
		String auth = jedis.auth("root");
		System.out.println(auth);
		if(auth.equals("OK")){
			List<FeeRtnVO> volist = new ArrayList<>();
			
			
			//选一个db专门放Fee
			jedis.select(1);
			Set<String> keys = jedis.keys("*");
			
			
			for (String id : keys) {
				byte[] bs = jedis.get(id.getBytes());
				Fee fee = (Fee) SerializeUtil.unserialize(bs);
				
				if(fee.getLocationReceive().intValue()==locationReceive&&fee.getLocationSend().intValue()==locationSend){
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
				}
				
				
			}
			return null;
		}
		
		return null;
		
	}

	@Override
	public List<FeeRtnVO> selectFeeByIdList(Integer feeId) {
		// TODO Auto-generated method stub
/*		List<FeeRtnVO> list = new ArrayList<>();
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
		}*/
		

		
		Jedis jedis = jedisPool.getResource();
		//密码验证 使用密码验证 需要在redis客户端使用命令 config set requirepass password 否则没有设置密码 但是auth的话会报错 can not get resource from pool
		String auth = jedis.auth("root");
		System.out.println(auth);
		if(auth.equals("OK")){
			//选一个db专门放Fee
			jedis.select(1);
			byte[] bs = jedis.get(String.valueOf(feeId).getBytes());
			Fee fee = (Fee) SerializeUtil.unserialize(bs);
			List<FeeRtnVO> list = new ArrayList<>();
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
		
		return null;
	}


}
