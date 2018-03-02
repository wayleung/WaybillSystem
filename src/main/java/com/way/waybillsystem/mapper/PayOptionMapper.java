package com.way.waybillsystem.mapper;

import com.way.waybillsystem.entity.PayOption;
import com.way.waybillsystem.entity.PayOptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayOptionMapper {
    int countByExample(PayOptionExample example);

    int deleteByExample(PayOptionExample example);

    int deleteByPrimaryKey(Integer poId);

    int insert(PayOption record);

    int insertSelective(PayOption record);

    List<PayOption> selectByExample(PayOptionExample example);

    PayOption selectByPrimaryKey(Integer poId);

    int updateByExampleSelective(@Param("record") PayOption record, @Param("example") PayOptionExample example);

    int updateByExample(@Param("record") PayOption record, @Param("example") PayOptionExample example);

    int updateByPrimaryKeySelective(PayOption record);

    int updateByPrimaryKey(PayOption record);
}