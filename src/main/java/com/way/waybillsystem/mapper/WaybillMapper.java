package com.way.waybillsystem.mapper;

import com.way.waybillsystem.entity.Waybill;
import com.way.waybillsystem.entity.WaybillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaybillMapper {
    int countByExample(WaybillExample example);

    int deleteByExample(WaybillExample example);

    int deleteByPrimaryKey(Long waybillNumber);

    int insert(Waybill record);

    int insertSelective(Waybill record);

    List<Waybill> selectByExample(WaybillExample example);

    Waybill selectByPrimaryKey(Long waybillNumber);

    int updateByExampleSelective(@Param("record") Waybill record, @Param("example") WaybillExample example);

    int updateByExample(@Param("record") Waybill record, @Param("example") WaybillExample example);

    int updateByPrimaryKeySelective(Waybill record);

    int updateByPrimaryKey(Waybill record);
}