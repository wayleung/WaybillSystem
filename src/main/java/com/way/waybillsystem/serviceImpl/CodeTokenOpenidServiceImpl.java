package com.way.waybillsystem.serviceImpl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.CodeTokenOpenid;
import com.way.waybillsystem.entity.CodeTokenOpenidExample;
import com.way.waybillsystem.entity.CodeTokenOpenidExample.Criteria;
import com.way.waybillsystem.mapper.CodeTokenOpenidMapper;
import com.way.waybillsystem.service.ICodeTokenOpenidService;
import com.way.waybillsystem.vo.QueryByPageObject;


@Service
public class CodeTokenOpenidServiceImpl implements ICodeTokenOpenidService {
	@Autowired
	private CodeTokenOpenidMapper codeTokenOpenidMapper;
	
	private Logger logger = LoggerFactory.getLogger(CodeTokenOpenidServiceImpl.class);

	@Override
	public int insertCodeTokenOpenid(CodeTokenOpenid codeTokenOpenid) {
		// TODO Auto-generated method stub
		codeTokenOpenid.setCreateTime(new Date());
		return codeTokenOpenidMapper.insertSelective(codeTokenOpenid);
	}

	@Override
	public int deleteCodeTokenOpenidByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return codeTokenOpenidMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateCodeTokenOpenidByPrimarykey(CodeTokenOpenid codeTokenOpenid) {
		// TODO Auto-generated method stub
		return codeTokenOpenidMapper.updateByPrimaryKeySelective(codeTokenOpenid);
	}

	@Override
	public CodeTokenOpenid selectCodeTokenOpenidByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return codeTokenOpenidMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<CodeTokenOpenid> selectAllCodeTokenOpenids() {
		CodeTokenOpenidExample example = new CodeTokenOpenidExample();
		// TODO Auto-generated method stub
		return codeTokenOpenidMapper.selectByExample(example );
	}

	@Override
	public PageInfo<CodeTokenOpenid> selectAllCodeTokenOpenidsByPage(QueryByPageObject queryObject) {
		// TODO Auto-generated method stub
		PageHelper.startPage(queryObject.getCurrentPage(), queryObject.getPageSize());
		//pagehelper不是内存分页是物理分页 PageHelper只对紧跟着的第一个SQL语句起作用
		CodeTokenOpenidExample example = new CodeTokenOpenidExample();
		List<CodeTokenOpenid> list =  codeTokenOpenidMapper.selectByExample(example);
		PageInfo<CodeTokenOpenid> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
	
	
	@Override
	public CodeTokenOpenid selectTokenByCode(String code) {
		CodeTokenOpenidExample example = new CodeTokenOpenidExample();
		// TODO Auto-generated method stub
		Criteria criteria = example.createCriteria();
		criteria.andCodeEqualTo(code);
		List<CodeTokenOpenid> list = codeTokenOpenidMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

}
