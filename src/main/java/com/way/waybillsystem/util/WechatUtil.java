package com.way.waybillsystem.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
/*import org.junit.Test;*/

import com.way.waybillsystem.wechat.entity.AccessToken;
import com.way.waybillsystem.wechat.entity.Button;
import com.way.waybillsystem.wechat.entity.Menu;
import com.way.waybillsystem.wechat.entity.ViewButton;

import net.sf.json.JSONObject;

public class WechatUtil {
	private static final String APPID = "wx4124bacd85335ca3";
	private static final String APPSECRET = "a8e85c223e9b16eb90e10e10703ec990";

	private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	private static final String UPLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	
	private static final String CREATE_MENU_URL="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	//接口地址
	/*接口调用请求说明

	https请求方式: GET
	https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
	*/
	//GET请求方法 方式是通过 URL 地址从微信后台获取我们需要的信息。
	public static JSONObject doGetStr(String url){
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		JSONObject jsonObject = null;
		try {
			HttpResponse response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if(entity!=null){
				String result = EntityUtils.toString(entity,"UTF-8");
				jsonObject = JSONObject.fromObject(result);
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonObject;
	}
	
	//POST请求方法 方式是将我们的一些变量参数outstr提交到微信后台。
	public static JSONObject doPostStr(String url,String outstr){
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		JSONObject jsonObject = null;
		try {
			httpPost.setEntity(new StringEntity(outstr, "UTF-8"));
			HttpResponse response  =  httpClient.execute(httpPost);
			String result = EntityUtils.toString(response.getEntity(),"UTF-8");
			jsonObject = JSONObject.fromObject(result);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	
	
	
	/*获取access_token方法
	 * 一搬把access_token存在本地*/
	public static AccessToken getAccessToken(){
		AccessToken token =  new AccessToken();
		String url =  ACCESS_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
		JSONObject jsonObject = doGetStr(url);
		if(jsonObject!=null){
			token.setAccess_token(jsonObject.getString("access_token"));
			token.setExpiresIn(jsonObject.getInt("expires_in"));
		}
		return token;
	}
	
	
	/**
	 * 文件上传
	 * @param filePath
	 * @param accessToken
	 * @param type
	 * @return
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws KeyManagementException
	 */
	public static String upload(String filePath, String accessToken,String type) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {
		File file = new File(filePath);
		if (!file.exists() || !file.isFile()) {
			throw new IOException("文件不存在");
		}

		String url = UPLOAD_URL.replace("ACCESS_TOKEN", accessToken).replace("TYPE",type);
		
		URL urlObj = new URL(url);
		//连接
		HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();

		con.setRequestMethod("POST"); 
		con.setDoInput(true);
		con.setDoOutput(true);
		//忽略缓存
		con.setUseCaches(false); 

		//设置请求头信息
		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Charset", "UTF-8");

		//设置边界
		String BOUNDARY = "----------" + System.currentTimeMillis();
		con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

		StringBuilder sb = new StringBuilder();
		sb.append("--");
		sb.append(BOUNDARY);
		sb.append("\r\n");
		sb.append("Content-Disposition: form-data;name=\"file\";filename=\"" + file.getName() + "\"\r\n");
		sb.append("Content-Type:application/octet-stream\r\n\r\n");

		byte[] head = sb.toString().getBytes("utf-8");

		//获得输出流
		OutputStream out = new DataOutputStream(con.getOutputStream());
		//输出表头
		out.write(head);

		//文件正文部分
		//把文件已流文件的方式 推入到url中
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		int bytes = 0;
		byte[] bufferOut = new byte[1024];
		while ((bytes = in.read(bufferOut)) != -1) {
			out.write(bufferOut, 0, bytes);
		}
		in.close();

		//结尾部分
		byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");//定义最后数据分隔线

		out.write(foot);

		out.flush();
		out.close();

		StringBuffer buffer = new StringBuffer();
		BufferedReader reader = null;
		String result = null;
		try {
			//定义BufferedReader输入流来读取URL的响应
			reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			if (result == null) {
				result = buffer.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

		JSONObject jsonObj = JSONObject.fromObject(result);
		System.out.println(jsonObj);
		String typeName = "media_id";
		if(!"image".equals(type)){
			typeName = type + "_media_id";
		}
		String mediaId = jsonObj.getString(typeName);
		return mediaId;
	}
	
	/**
	 * 组装菜单 生成菜单接口既可以更新 也可以新增 如果原本有再运行就是更新菜单
	 * 还有删除菜单的接口
	 * @return
	 */
	public static Menu initMenu(){
		Menu menu = new Menu();
/*		ClickButton button11 = new ClickButton();
		button11.setName("click菜单");
		button11.setType("click");
		button11.setKey("11");*/
		
		ViewButton button11 = new ViewButton();
		button11.setName("官方网站");
		button11.setType("view");
		button11.setUrl("http://liangliwei138080.free.ngrok.cc/waybill/userlogin.jsp");
		
		
		ViewButton button21 = new ViewButton();
		button21.setName("运单查询");
		button21.setType("view");
		button21.setUrl("http://liangliwei138080.free.ngrok.cc/waybill/search.jsp");
		
		
		ViewButton button = new ViewButton();
		button.setName("绑定账号");
		button.setType("view");
		button.setUrl("http://liangliwei138080.free.ngrok.cc/waybill/login.do");
		
/*		ClickButton button31 = new ClickButton();
		button31.setName("扫码事件");
		button31.setType("scancode_push");
		button31.setKey("31");
		
		ClickButton button32 = new ClickButton();
		button32.setName("地理位置");
		button32.setType("location_select");
		button32.setKey("32");*/
		
/*		Button button = new Button();
		button.setName("菜单");
		button.setSub_button(new Button[]{button31,button32});*/
		
		menu.setButton(new Button[]{button11,button21,button});
		return menu;
	}
	
	
	public static int createMenu(String token,String menu){
		int result = 0;
		String url  = CREATE_MENU_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doPostStr(url, menu);
		if(jsonObject!=null){
			return jsonObject.getInt("errcode");
		}
		return result;
	}
	
/*	@Test*/
	public void testtoken(){
		
		AccessToken token  =getAccessToken();
		System.out.println(token.getAccess_token());
		System.out.println(token.getExpiresIn());
		
		String menu = JSONObject.fromObject(WechatUtil.initMenu()).toString();
		int result = WechatUtil.createMenu(token.getAccess_token(), menu);
		if(result==0){
			System.out.println("创建菜单成功");
		}else{
			System.out.println("错误码:"+result);
		}
		
/*		try {
		
		
		String path = "C:/Users/Administrator/Pictures/timg.jpg";
		String mediId = upload(path, token.getAccess_token(), "image");
		System.out.println(mediId);
		} catch (KeyManagementException | NoSuchAlgorithmException | NoSuchProviderException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
}
