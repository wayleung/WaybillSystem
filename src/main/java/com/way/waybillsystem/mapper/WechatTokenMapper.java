package com.way.waybillsystem.mapper;

import com.way.waybillsystem.entity.WechatToken;
import com.way.waybillsystem.entity.WechatTokenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WechatTokenMapper {
    int countByExample(WechatTokenExample example);

    int deleteByExample(WechatTokenExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WechatToken record);

    int insertSelective(WechatToken record);

    List<WechatToken> selectByExample(WechatTokenExample example);

    WechatToken selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WechatToken record, @Param("example") WechatTokenExample example);

    int updateByExample(@Param("record") WechatToken record, @Param("example") WechatTokenExample example);

    int updateByPrimaryKeySelective(WechatToken record);

    int updateByPrimaryKey(WechatToken record);
    
    WechatToken selectLastWechatToken();
}