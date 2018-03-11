package com.way.waybillsystem.mapper;

import com.way.waybillsystem.entity.CodeTokenOpenid;
import com.way.waybillsystem.entity.CodeTokenOpenidExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CodeTokenOpenidMapper {
    int countByExample(CodeTokenOpenidExample example);

    int deleteByExample(CodeTokenOpenidExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CodeTokenOpenid record);

    int insertSelective(CodeTokenOpenid record);

    List<CodeTokenOpenid> selectByExample(CodeTokenOpenidExample example);

    CodeTokenOpenid selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CodeTokenOpenid record, @Param("example") CodeTokenOpenidExample example);

    int updateByExample(@Param("record") CodeTokenOpenid record, @Param("example") CodeTokenOpenidExample example);

    int updateByPrimaryKeySelective(CodeTokenOpenid record);

    int updateByPrimaryKey(CodeTokenOpenid record);
}