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
import com.way.waybillsystem.entity.Message;
import com.way.waybillsystem.entity.MessageExample;
import com.way.waybillsystem.entity.MessageExample.Criteria;
import com.way.waybillsystem.mapper.MessageMapper;
import com.way.waybillsystem.service.IMessageService;
import com.way.waybillsystem.vo.QueryByPageObject;

@Service
public class MessageServiceImpl implements IMessageService {
	@Autowired
	private MessageMapper messageMapper;
	
	private Logger Logger = LoggerFactory.getLogger(MessageServiceImpl.class);
	
	@Override
	@Transactional
	public int insertMessage(Message message) {
		// TODO Auto-generated method stub
		message.setCreateTime(new Date());
		return messageMapper.insertSelective(message);
	}

	@Override
	@Transactional
	public int deleteMessageByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return messageMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional
	public int updateMessageByPrimarykey(Message message) {
		// TODO Auto-generated method stub
		return messageMapper.updateByPrimaryKeySelective(message);
	}

	@Override
	public Message selectMessageByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return messageMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Message> selectAllMessages() {
		// TODO Auto-generated method stub
		MessageExample example = new MessageExample();
		return messageMapper.selectByExample(example);
	}

	@Override
	public PageInfo<Message> selectAllMessagesByPage(QueryByPageObject queryObject) {
		// TODO Auto-generated method stub
		PageHelper.startPage(queryObject.getCurrentPage(), queryObject.getPageSize());
		//pagehelper不是内存分页是物理分页 PageHelper只对紧跟着的第一个SQL语句起作用
		MessageExample example = new MessageExample();
		List<Message> list =  messageMapper.selectByExample(example);
		PageInfo<Message> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public Message selectMessageByEmail(String email) {
		MessageExample example = new MessageExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmailEqualTo(email);
		// TODO Auto-generated method stub
		List<Message> list = messageMapper.selectByExample(example );
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
		 
	}

}
