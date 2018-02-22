package com.way.waybillsystem.mapper;

import com.way.waybillsystem.entity.PayCharge;
import com.way.waybillsystem.entity.PayChargeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayChargeMapper {
    int countByExample(PayChargeExample example);

    int deleteByExample(PayChargeExample example);

    int deleteByPrimaryKey(Integer pcId);

    int insert(PayCharge record);

    int insertSelective(PayCharge record);

    List<PayCharge> selectByExample(PayChargeExample example);

    PayCharge selectByPrimaryKey(Integer pcId);

    int updateByExampleSelective(@Param("record") PayCharge record, @Param("example") PayChargeExample example);

    int updateByExample(@Param("record") PayCharge record, @Param("example") PayChargeExample example);

    int updateByPrimaryKeySelective(PayCharge record);

    int updateByPrimaryKey(PayCharge record);
}