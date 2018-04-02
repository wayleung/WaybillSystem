package com.way.waybillsystem.serviceImpl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.User;
import com.way.waybillsystem.entity.UserExample;
import com.way.waybillsystem.entity.UserExample.Criteria;
import com.way.waybillsystem.mapper.UserMapper;
import com.way.waybillsystem.service.IUserService;
import com.way.waybillsystem.util.TimeUtil;
import com.way.waybillsystem.vo.QueryByPageObject;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;
	
	private Logger Logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	@Transactional
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		user.setCreateTime(new Date());
		return userMapper.insertSelective(user);
	}

	@Override
	@Transactional
	public int deleteUserByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional
	public int updateUserByPrimarykey(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public User selectUserByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> selectAllUsers() {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		return userMapper.selectByExample(example);
	}

	@Override
	public PageInfo<User> selectAllUsersByPage(QueryByPageObject queryObject) {
		// TODO Auto-generated method stub
		PageHelper.startPage(queryObject.getCurrentPage(), queryObject.getPageSize());
		//pagehelper不是内存分页是物理分页 PageHelper只对紧跟着的第一个SQL语句起作用
		UserExample example = new UserExample();
		List<User> list =  userMapper.selectByExample(example);
		PageInfo<User> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public User selectUserByAccount(String account) {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andAccountEqualTo(account);
		List<User> list = userMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
		
	}

	@Override
	public int wechatBind(User user,String openid) {
		System.out.println("----"+openid);
		// TODO Auto-generated method stub
		user.setWechatId(openid);
		return userMapper.updateByPrimaryKey(user);
	}

	@Override
	public int wechatUnbind(User user) {
		// TODO Auto-generated method stub
		user.setWechatId(null);
		return userMapper.updateByPrimaryKey(user);
	}

}
