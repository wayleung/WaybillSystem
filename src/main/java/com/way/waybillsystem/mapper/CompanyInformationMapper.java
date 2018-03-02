package com.way.waybillsystem.mapper;

import com.way.waybillsystem.entity.CompanyInformation;
import com.way.waybillsystem.entity.CompanyInformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyInformationMapper {
    int countByExample(CompanyInformationExample example);

    int deleteByExample(CompanyInformationExample example);

    int insert(CompanyInformation record);

    int insertSelective(CompanyInformation record);

    List<CompanyInformation> selectByExample(CompanyInformationExample example);

    int updateByExampleSelective(@Param("record") CompanyInformation record, @Param("example") CompanyInformationExample example);

    int updateByExample(@Param("record") CompanyInformation record, @Param("example") CompanyInformationExample example);
}