package com.way.waybillsystem.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.way.waybillsystem.vo.Result;
import com.way.waybillsystem.exception.SystemException;



/**
 * 
* @author Way Leung
* @Description: TODO(用一句话描述该文件做什么)   
* @date 2018年2月18日
 */
public class BaseAction{

	

	
	
	@ExceptionHandler({SystemException.class})
	public @ResponseBody Result<Object> ExceptionHandler(SystemException e, HttpServletResponse response) {
	    Result<Object> result = new Result<Object>();
        result.setSuccess(false);
        result.setCode(e.getErrorCode().getCode());
        result.setMsg(e.getMessage() == null ? "" : e.getMessage());
        return result;
	}
	

	@ExceptionHandler({Exception.class})
	public @ResponseBody Result<Object> ExceptionHandler(Exception e, HttpServletResponse response) {
	    Result<Object> result = new Result<Object>();
        result.setSuccess(false);
        //result.setCode(e.getErrorCode().getCode());
        result.setMsg(e.getMessage() == null ? "" : e.getMessage());
        return result;
	}
	

	public void outPut(byte[] b, String type, HttpServletResponse response) {
		try {
			ServletOutputStream out = response.getOutputStream();
			response.setContentType(type);
			out.write(b);
			out.flush();
			out.close();
		} catch (Exception e) {
			//log.error(e.getMessage(), e);
		}
	}

	public void outPutFile(byte[] b, String type, HttpServletResponse response,
			String fileName) {
		try {
			ServletOutputStream out = response.getOutputStream();
			response.setContentType(type);
			response.setHeader("Content-Disposition", "attachment;filename="
					+ new String(fileName.getBytes("gb2312"), "ISO8859-1"));
			out.write(b);
			out.flush();
			out.close();
		} catch (Exception e) {
			//log.error(e.getMessage(), e);
		}
	}

	protected void downloadFile(HttpServletResponse response, File file)
			throws Exception {
		InputStream fileInputStream = new FileInputStream(file);// 构造一个读取文件的IO流对象
		BufferedInputStream bins = new BufferedInputStream(fileInputStream);// 放到缓冲流里面
		OutputStream outs = response.getOutputStream();// 获取文件输出IO流
		BufferedOutputStream bouts = new BufferedOutputStream(outs);
		response.setContentType("application/pdf");// 设置response内容的类型
		response.setHeader("Content-Disposition", "attachment;filename="
				+ new String(file.getName().getBytes("gb2312"), "ISO8859-1"));
		int bytesRead = 0;		byte[] buffer = new byte[8192];// 开始向网络传输文件流
		while ((bytesRead = bins.read(buffer, 0, 8192)) != -1) {
			bouts.write(buffer, 0, bytesRead);
		}
		bouts.flush();// 这里一定要调用flush()方法
		fileInputStream.close();
		bins.close();
		outs.close();
		bouts.close();
	}


}
