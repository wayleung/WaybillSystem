package com.way.waybillsystem.mapper;

import com.way.waybillsystem.entity.WaybillStatus;
import com.way.waybillsystem.entity.WaybillStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaybillStatusMapper {
    int countByExample(WaybillStatusExample example);

    int deleteByExample(WaybillStatusExample example);

    int deleteByPrimaryKey(Long wsId);

    int insert(WaybillStatus record);

    int insertSelective(WaybillStatus record);

    List<WaybillStatus> selectByExample(WaybillStatusExample example);

    WaybillStatus selectByPrimaryKey(Long wsId);

    int updateByExampleSelective(@Param("record") WaybillStatus record, @Param("example") WaybillStatusExample example);

    int updateByExample(@Param("record") WaybillStatus record, @Param("example") WaybillStatusExample example);

    int updateByPrimaryKeySelective(WaybillStatus record);

    int updateByPrimaryKey(WaybillStatus record);
}