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
import com.way.waybillsystem.entity.Admin;
import com.way.waybillsystem.entity.AdminExample;
import com.way.waybillsystem.mapper.AdminMapper;
import com.way.waybillsystem.service.IAdminService;
import com.way.waybillsystem.vo.QueryByPageObject;

@Service
public class AdminServiceImpl implements IAdminService {
	@Autowired
	private AdminMapper adminMapper;
	
	private Logger Logger = LoggerFactory.getLogger(AdminMapper.class);
	
	@Override
	@Transactional
	public int insertAdmin(Admin admin) {
		// TODO Auto-generated method stub
		admin.setCreateTime(new Date());
		return adminMapper.insertSelective(admin);
	}

	@Override
	@Transactional
	public int deleteAdminByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return adminMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional
	public int updateAdminByPrimarykey(Admin admin) {
		// TODO Auto-generated method stub
		return adminMapper.updateByPrimaryKeySelective(admin);
	}

	@Override
	public Admin selectAdminByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return adminMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Admin> selectAllAdmins() {
		// TODO Auto-generated method stub
		AdminExample example = new AdminExample();
		return adminMapper.selectByExample(example);
	}

	@Override
	public PageInfo<Admin> selectAllAdminsByPage(QueryByPageObject queryObject) {
		// TODO Auto-generated method stub
		//queryObject.getCurrentPage()还要做判断!!!!!!!!!!!?
		PageHelper.startPage(queryObject.getCurrentPage(), queryObject.getPageSize());
		//pagehelper不是内存分页是物理分页 PageHelper只对紧跟着的第一个SQL语句起作用
		AdminExample example = new AdminExample();
		List<Admin> list =  adminMapper.selectByExample(example);
		PageInfo<Admin> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

}
