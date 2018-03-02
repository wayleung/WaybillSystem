package com.way.waybillsystem.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.Message;
import com.way.waybillsystem.vo.QueryByPageObject;

public interface IMessageService {
	int insertMessage(Message message);
	
	int deleteMessageByPrimaryKey(Integer id);
	
	int updateMessageByPrimarykey(Message message);
	
	Message selectMessageByPrimaryKey(Integer id);
	
	List<Message> selectAllMessages();
	
	PageInfo<Message> selectAllMessagesByPage(QueryByPageObject queryObject);
}

