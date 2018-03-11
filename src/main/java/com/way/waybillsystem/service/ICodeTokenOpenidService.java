package com.way.waybillsystem.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.way.waybillsystem.entity.CodeTokenOpenid;
import com.way.waybillsystem.vo.QueryByPageObject;

/**
 * 
* @author Way Leung
* @Description: TODO(用一句话描述该文件做什么)   
* @date 2018年2月17日
 */


public interface ICodeTokenOpenidService {
	int insertCodeTokenOpenid(CodeTokenOpenid codeTokenOpenid);
	
	int deleteCodeTokenOpenidByPrimaryKey(Long id);
	
	int updateCodeTokenOpenidByPrimarykey(CodeTokenOpenid codeTokenOpenid);
	
	CodeTokenOpenid selectCodeTokenOpenidByPrimaryKey(Long id);
	
	List<CodeTokenOpenid> selectAllCodeTokenOpenids();
	
	PageInfo<CodeTokenOpenid> selectAllCodeTokenOpenidsByPage(QueryByPageObject queryObject);
	
	CodeTokenOpenid selectTokenByCode(String code);

}
