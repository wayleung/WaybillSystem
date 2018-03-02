package com.way.waybillsystem.util;



import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

public class HttpClientUtil {
	
	//TODO
/*	private boolean isProxy = true;
	
	private String  proxyAddress = "cnpriproxy.aia.biz";

	private int  proxyPort = 10938;*/
	
	/**
	 * 
	 * @param url 请求链接
	 * @param message post对象参数jsonbody
	 * @param httpProxy 判断是否需要代理
	 * @return
	 */
	public static String executeHttpstatic(String url,String message,HttpProxy httpProxy){
		return new HttpClientUtil().executeHttp( url, message,httpProxy);
	}
	
	public HttpClientUtil(){
		super();
	}
	
	/**
	 * 
	 * @param url 请求链接
	 * @param message post对象参数jsonbody
	 * @param httpProxy 判断是否需要代理
	 * @return
	 */
	public String executeHttp(String url,String message,HttpProxy httpProxy){
		HttpClient httpClient = new DefaultHttpClient();
		if(httpProxy.isProxy()){
			HttpHost proxy = new HttpHost(httpProxy.getAddress(), httpProxy.getPort());
			httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);   
		}
		HttpPost httpPost = new HttpPost(url);
		HttpResponse httpResponse = null;
		String jsonResult = null;
		JSONObject jsonObject = new JSONObject();
		try {
			if(StringUtils.isNotEmpty(message)) {
				StringEntity stringEntity = new StringEntity(message,HTTP.UTF_8);
				httpPost.setEntity(stringEntity);
			}
			httpResponse = httpClient.execute(httpPost);
			jsonResult = EntityUtils.toString(httpResponse.getEntity());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			jsonObject.put("success", "UnsupportedEncodingException");
			jsonObject.put("data", e.toString());
			jsonResult = jsonObject.toString();
			System.out.println("enter the first exception");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			jsonObject.put("success", "ClientProtocolException");
			jsonObject.put("data", e.toString());
			jsonResult = jsonObject.toString();
			System.out.println("enter the second exception");
		} catch (IOException e) {
			e.printStackTrace();
			if(e instanceof org.apache.http.conn.HttpHostConnectException){
				jsonObject.put("success", "proxy");
				jsonObject.put("data", e.toString());
				jsonResult = jsonObject.toString();
			}else{
				jsonObject.put("success", "IOException");
				jsonObject.put("data", e.toString());
				jsonResult = jsonObject.toString();
			}
			System.out.println("enter the third exception");
		} catch(Exception e){
			e.printStackTrace();
			jsonObject.put("success", "Exception");
			jsonObject.put("data", e.toString());
			jsonResult = jsonObject.toString();
			System.out.println("enter the fourth exception");
		}finally{
			closeHttpResponse(httpResponse);
			closeHttpClient(httpClient);
		}
		return jsonResult;
	}
	
	private void closeHttpClient(HttpClient httpClient){
		if(httpClient!=null){
			httpClient.getConnectionManager().shutdown();
		}
	}
	
	private void closeHttpResponse(HttpResponse httpResponse){
		try {
			if(httpResponse!=null){
				EntityUtils.consume(httpResponse.getEntity());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
