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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/*import org.junit.Test;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.XStream;
import com.way.waybillsystem.action.WechatAction;
import com.way.waybillsystem.exception.ErrorCodeConstant;
import com.way.waybillsystem.exception.SystemException;
import com.way.waybillsystem.vo.WaybillStatusRtnVO;
import com.way.waybillsystem.wechat.entity.AccessToken;
import com.way.waybillsystem.wechat.entity.Button;
import com.way.waybillsystem.wechat.entity.Menu;
import com.way.waybillsystem.wechat.entity.News;
import com.way.waybillsystem.wechat.entity.NewsMessage;
import com.way.waybillsystem.wechat.entity.TextMessage;
import com.way.waybillsystem.wechat.entity.ViewButton;

import net.sf.json.JSONObject;

public class WechatUtil {
	private static final String APPID = "wxc6970e3fd4e08fc5";
	private static final String APPSECRET = "fd40a25345ca888b87b888b5c21c69c5";
	//接口地址
	private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	private static final String UPLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	private static final String CREATE_MENU_URL="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	private static final String SEND_TEMPLATE_URL="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
	
	private static final String TEMPLATE_ID = "9UL1UtQ6gZu8YDIb6EksEIu1uM4r282M73q0AuSceTE";
	
	
	private Logger logger = LoggerFactory.getLogger(WechatAction.class);
	
	public static String getAppid() {
		return APPID;
	}

	
	
	
	public static String getAppsecret() {
		return APPSECRET;
	}




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
	
	
	
	
	/**
	 * 1、建议公众号开发者使用中控服务器统一获取和刷新Access_token，其他业务逻辑服务器所使用的access_token均来自于该中控服务器，不应该各自去刷新，否则容易造成冲突，导致access_token覆盖而影响业务；

2、目前Access_token的有效期通过返回的expire_in来传达，目前是7200秒之内的值。中控服务器需要根据这个有效时间提前去刷新新access_token。在刷新过程中，中控服务器可对外继续输出的老access_token，此时公众平台后台会保证在5分钟内，新老access_token都可用，这保证了第三方业务的平滑过渡；

3、Access_token的有效时间可能会在未来有调整，所以中控服务器不仅需要内部定时主动刷新，还需要提供被动刷新access_token的接口，这样便于业务服务器在API调用获知access_token已超时的情况下，可以触发access_token的刷新流程。
	 * @return
	 */
	public static AccessToken getAccessToken(){
		AccessToken token =  new AccessToken();
		String url =  ACCESS_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
		JSONObject jsonObject = doGetStr(url);
		if(jsonObject!=null&&StringUtils.isNotEmpty(jsonObject.getString("access_token"))){
			token.setAccess_token(jsonObject.getString("access_token"));
			token.setExpiresIn(jsonObject.getInt("expires_in"));
		}else{
			throw new SystemException(ErrorCodeConstant.E20001,ErrorCodeConstant.E20001.getMessage());
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
		button11.setUrl("http://wayleung80.tunnel.echomod.cn/wechatUserLogin");
		
		
		ViewButton button21 = new ViewButton();
		button21.setName("运单查询");
		button21.setType("view");
		button21.setUrl("http://wayleung80.tunnel.echomod.cn/user/search.html");
		
		
		ViewButton button = new ViewButton();
		button.setName("绑定账号");
		button.setType("view");
		button.setUrl("http://wayleung80.tunnel.echomod.cn/login.do");
		
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
	
	
	
	
	
	public static String createMenu(String token,String menu){
		String url  = CREATE_MENU_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doPostStr(url, menu);
		return jsonObject.toString();
	}
	
	
	
	
	
/**
 *  开发者通过检验signature对请求进行校验（下面有校验方式）。若确认此次GET请求来自微信服务器，请原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败。加密/校验流程如下：

1）将token、timestamp、nonce三个参数进行字典序排序 2）将三个参数字符串拼接成一个字符串进行sha1加密 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
 * @param token
 * @param signature
 * @param timestamp
 * @param nonce
 * @return
 */
public static boolean checkSignature(String token,String signature,String timestamp,String nonce){
	
	String [] arr = new String []{token,timestamp,nonce};
	//排序
	Arrays.sort(arr);
	
	//生成字符串
	StringBuffer content =  new StringBuffer();
	for(int i=0;i<arr.length;i++){
		content.append(arr[i]);
	}
	
	//sha1加密
	String temp = getSha1(content.toString());
	
	return temp.equals(signature);
}

public static String getSha1(String str ) {
	if (str == null || str.length() == 0) {
	return null ;
	}
	char hexDigits [] = { '0' , '1' , '2' , '3' , '4', '5' , '6' , '7' , '8' , '9' ,
	'a', 'b', 'c', 'd', 'e', 'f' };
	       try {
	           MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
	            mdTemp.update( str.getBytes( "UTF-8"));

	            byte[] md = mdTemp .digest();
	            int j = md .length ;
	            char buf [] = new char[ j * 2];
	            int k = 0;
	            for (int i = 0; i < j ; i ++) {
	                 byte byte0 = md [i ];
	                 buf[ k++] = hexDigits[byte0 >>> 4 & 0xf];
	                 buf[ k++] = hexDigits[byte0 & 0xf];
	           }
	            return new String(buf );
	      } catch (Exception e ) {
	            return null ;
	      }
}

	
	
/**
 * 发送模板消息
 * @param toUser
 * @param access_token
 * @param waybillStatusRtnVO
 * @return
 */
public static String sendTemplateMessage(String toUser,String access_token,WaybillStatusRtnVO waybillStatusRtnVO) {
    String url = SEND_TEMPLATE_URL.replace("ACCESS_TOKEN", access_token);
    
    
    
    String locationName=waybillStatusRtnVO.getLocationName();
	String lacationTime=TimeUtil.dateToString(waybillStatusRtnVO.getLacationTime(), null);
	String title="运单最新新状态";
	String remark="点击可以查看运单物流详情";
	String statusName=waybillStatusRtnVO.getStatusName();
	String waybillNumber=waybillStatusRtnVO.getWaybillNumber().toString();
	String toUrl="http://wayleung80.tunnel.echomod.cn/user/search.html";
	
	String jsonString = "{\"data\":{\"locationName\":{\"color\":\"#173177\",\"value\":\""+locationName+"\"},\"lacationTime\":{\"color\":\"#173177\",\"value\":\""+lacationTime+"\"},\"title\":{\"color\":\"#173177\",\"value\":\""+title+"\"},\"remark\":{\"color\":\"#173177\",\"value\":\""+remark+"\"},\"statusName\":{\"color\":\"#173177\",\"value\":\""+statusName+"\"},\"waybillNumber\":{\"color\":\"#173177\",\"value\":\""+waybillNumber+"\"}},\"template_id\":\""+TEMPLATE_ID+"\",\"touser\":\""+toUser+"\",\"url\":\""+toUrl+"\"}";
    JSONObject jsonObject = WechatUtil.doPostStr(url, jsonString);
    
    return jsonObject.toString();
    //log.info("模板消息发送结果："+result);
}

/**
 * 测试发送模板消息
 * @param toUser
 * @param access_token
 * @return
 */
public static String testSendTemplateMessage(String toUser,String access_token) {
    String url = SEND_TEMPLATE_URL.replace("ACCESS_TOKEN", access_token);
    
    
    
    String locationName="李晓君";
	String title="来自一只猪的告白";
	String remark="我爱你";
	String statusName="梁立威";
	String toUrl="http://wayleung80.tunnel.echomod.cn/user/search.html";
    String t_ID = "GANqsi6GuWjvXw9QsHDyFpgc8LBjmcpoYebWf4DzCIQ";
    String jsonString = "{\"data\":{\"locationName\":{\"color\":\"#173177\",\"value\":\"李晓君\"},\"title\":{\"color\":\"#173177\",\"value\":\"来自一只猪的告白\"},\"remark\":{\"color\":\"#173177\",\"value\":\"我爱你，等我哟！\"},\"statusName\":{\"color\":\"#173177\",\"value\":\"梁立威\"}},\"template_id\":\""+t_ID+"\",\"touser\":\""+toUser+"\",\"url\":\""+toUrl+"\"}";
	JSONObject jsonObject = WechatUtil.doPostStr(url, jsonString);
    
    return jsonObject.toString();
    //log.info("模板消息发送结果："+result);
}

	
/*	@Test*/
	public void testtoken(){
		
		AccessToken token=getAccessToken();
		System.out.println(token.getAccess_token());
		System.out.println(token.getExpiresIn());
		

/*		try {
		
		
		String path = "C:/Users/Administrator/Pictures/timg.jpg";
		String mediId = upload(path, token.getAccess_token(), "image");
		System.out.println(mediId);
		} catch (KeyManagementException | NoSuchAlgorithmException | NoSuchProviderException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	
	
	public static final String MESSAGE_TEXT = "text";
	public static final String MESSAGE_NEWS = "news";
	public static final String MESSAGE_IMAGE = "image";
	public static final String MESSAGE_VOICE = "voice";
	public static final String MESSAGE_VIDEO = "video";
	public static final String MESSAGE_LINK = "link";
	public static final String MESSAGE_LOCATION = "location";
	
/*	事件推送-event
		-关注 subscribe
		-取消关注 unsubscribe
		-菜单点击 -CLICK VIEW*/
	public static final String MESSAGE_EVENT = "event";
	public static final String MESSAGE_SUBSCRIBE = "subscribe";
	public static final String MESSAGE_UNSUBSCRIBE = "unsubcribe";
	public static final String MESSAGE_CLICK = "CLICK";
	public static final String MESSAGE_VIEW = "VIEW";
	
	
    /**
     * xml转map
     * @param req
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    public static Map<String,String> xmlToMap(HttpServletRequest req) throws IOException, DocumentException {
        HashMap<String, String> map = new HashMap<String, String>();
        SAXReader saxReader = new SAXReader();
        ServletInputStream inputStream = req.getInputStream();
        Document document = saxReader.read(inputStream);

        Element rootElement = document.getRootElement();

        List <Element> elements = rootElement.elements();

        for (Element el : elements){
            map.put(el.getName(),el.getText());
        }
        inputStream.close();
        return map;
    }

    /**
     * 文本消息对象转换为xml
     * @param textMessage
     * @return
     */
    public static String textMessageToXml (TextMessage textMessage){
        XStream xStream = new XStream();
        xStream.alias("xml",textMessage.getClass());
        return xStream.toXML(textMessage);
    }
    

    /**
     * 图文消息转换为xml
     * @param newsMessage
     * @return
     */
    public static String newsMessageToXml(NewsMessage newsMessage){
		XStream xsStream = new XStream();
		xsStream.alias("xml", newsMessage.getClass());
		xsStream.alias("item", new News().getClass());
		return xsStream.toXML(newsMessage);
    }
    
    
    /**
     * 图文消息组装
     * @param toUserName
     * @param fromUserName
     * @return
     */
    public static String initNewsMessage(String toUserName,String fromUserName){
    	String message = null;
    	List<News> newsList = new ArrayList<News>();
    	NewsMessage newsMessage = new NewsMessage();
    	
    	News news = new News();
    	news.setTitle("物流、运单最新状态");
    	news.setDescription("2016-11-25 04:32:45\n[四川成都分拨中心]从站点发出，本次转运目的地：四川宜宾公司\n2016-11-25 03:22:30\n[四川成都分拨中心]在分拨中心进行卸车扫描 \n2016-11-23 21:19:03\n[浙江义乌分拨中心]进行装车扫描，即将发往：四川成都分拨中心\n2016-11-23 21:16:39\n[浙江义乌分拨中心]在分拨中心进行称重扫描\n2016-11-23 20:28:27\n[浙江主城区公司义乌山口服务部]进行揽件扫描\n2016-11-23 19:56:50\n[浙江主城区公司义乌山口服务部]进行下级地点扫描，将发往：四川南充分拨中心\n2016-11-23 17:40:47\n[浙江主城区公司义乌山口服务部]进行揽件扫描");
    	news.setPicUrl("http://120.78.89.34/waybill/img/cover.jpg");
    	news.setUrl("http://www.baidu.com");
    	
    	newsList.add(news);
    	
    	newsMessage.setToUserName(fromUserName);
    	newsMessage.setFromUserName(toUserName);
    	newsMessage.setCreateTime(new Date().getTime());
    	newsMessage.setMsgType(MESSAGE_NEWS);
    	newsMessage.setArticles(newsList);
    	newsMessage.setArticleCount(newsList.size());
    	
    	message = newsMessageToXml(newsMessage);
    	return message;
    	
    }
	
}
