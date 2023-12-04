package com.jkf.channel.gateway.utils;


import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 *
 */
public class HttpUtil {

	public static String sendPostJson(String httpUrl, String params) {
		//生产HttpPost
		HttpPost httpPost = new HttpPost(httpUrl);
		CloseableHttpClient client = HttpClients.createDefault();
		StringEntity entity = new StringEntity(params, "utf-8");
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httpPost.setEntity(entity);
		try {
			HttpResponse response = client.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == 200) {
				HttpEntity responseEntity = response.getEntity();
				return EntityUtils.toString(responseEntity, "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String sendPost(String pathUrl, String param) throws Exception {
		URL url=new URL(pathUrl);
		byte[] postDataBytes = param.toString().getBytes("UTF-8");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		conn.setConnectTimeout(30000);
		conn.setReadTimeout(30000);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Charsert", "UTF-8");
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		conn.setRequestProperty("Content-Length",
				String.valueOf(postDataBytes.length));
		conn.setDoOutput(true);
		conn.getOutputStream().write(postDataBytes);
		Reader in = new BufferedReader(new InputStreamReader(
				conn.getInputStream(), "UTF-8"));
		StringBuilder sb = new StringBuilder();
		for (int c; (c = in.read()) >= 0;){
			sb.append((char) c);
		}
		return sb.toString();
	}

	public static String sendPost(String pathUrl, Map<String, String> map) throws Exception {
		URL url=new URL(pathUrl);
		StringBuilder postData = new StringBuilder();
		for (Map.Entry<String, String> param : map.entrySet()) {
			if (postData.length() != 0){
				postData.append('&');
			}
			postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
			postData.append('=');
			postData.append(URLEncoder.encode(
					String.valueOf(param.getValue()), "UTF-8"));
		}
		byte[] postDataBytes = postData.toString().getBytes("UTF-8");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		conn.setConnectTimeout(30000);
		conn.setReadTimeout(30000);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Charsert", "UTF-8");
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		conn.setRequestProperty("Content-Length",
				String.valueOf(postDataBytes.length));
		conn.setDoOutput(true);
		conn.getOutputStream().write(postDataBytes);
		Reader in = new BufferedReader(new InputStreamReader(
				conn.getInputStream(), "UTF-8"));
		StringBuilder sb = new StringBuilder();
		for (int c; (c = in.read()) >= 0;){
			sb.append((char) c);
		}
		return sb.toString();
	}

	public static String sendPostObject(String pathUrl, Map<String, Object> map) throws Exception {
		URL url=new URL(pathUrl);
		StringBuilder postData = new StringBuilder();
		for (Map.Entry<String, Object> param : map.entrySet()) {
			if (postData.length() != 0){
				postData.append('&');
			}
			postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
			postData.append('=');
			postData.append(URLEncoder.encode(
					String.valueOf(param.getValue()), "UTF-8"));
		}
		byte[] postDataBytes = postData.toString().getBytes("UTF-8");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		conn.setConnectTimeout(30000);
		conn.setReadTimeout(30000);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Charsert", "UTF-8");
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		conn.setRequestProperty("Content-Length",
				String.valueOf(postDataBytes.length));
		conn.setDoOutput(true);
		conn.getOutputStream().write(postDataBytes);
		Reader in = new BufferedReader(new InputStreamReader(
				conn.getInputStream(), "UTF-8"));
		StringBuilder sb = new StringBuilder();
		for (int c; (c = in.read()) >= 0;){
			sb.append((char) c);
		}
		return sb.toString();
	}


	 public static String sendGet(String url, String param, String agent)  throws Exception {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString="";
			if(StringUtils.isNotBlank(param)){
				urlNameString= url + "?" + param;
			}else{
				urlNameString=url;
			}
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("Accept", "*/*");
			connection.setRequestProperty("Connection", "Keep-Alive");
			connection.setRequestProperty("User-Agent", agent);

			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}


	public static String sendJson(String url, String json) throws IOException {
		String body = "";
		//创建httpclient对象
		CloseableHttpClient client = HttpClients.createDefault();
		//创建post方式请求对象
		HttpPost httpPost = new HttpPost(url);
		//装填参数
		StringEntity s = new StringEntity(json, "utf-8");
		s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
				"application/json"));
		//设置参数到请求对象中
		httpPost.setEntity(s);
		//设置header信息
		//指定报文头【Content-type】、【User-Agent】
		httpPost.setHeader("Accept","*/*");
		httpPost.setHeader("Content-type", "application/json");
		httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		//执行请求操作，并拿到结果（同步阻塞）
		CloseableHttpResponse response = client.execute(httpPost);
		//获取结果实体
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			//按指定编码转换结果实体为String类型
			body = EntityUtils.toString(entity, "UTF-8");
		}
		EntityUtils.consume(entity);
		//释放链接
		response.close();
		return body;
	}
	public static String sendTxt(String url, String txt) throws IOException {
		String body = "";
		//创建httpclient对象
		CloseableHttpClient client = HttpClients.createDefault();
		//创建post方式请求对象
		HttpPost httpPost = new HttpPost(url);
		//装填参数
		StringEntity s = new StringEntity(txt, "utf-8");
		s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
				"text/plain"));
		//设置参数到请求对象中
		httpPost.setEntity(s);
		//设置header信息
		//指定报文头【Content-type】、【User-Agent】
		httpPost.setHeader("Accept","*/*");
		httpPost.setHeader("Content-type", "text/plain");
		httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		//执行请求操作，并拿到结果（同步阻塞）
		CloseableHttpResponse response = client.execute(httpPost);
		//获取结果实体
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			//按指定编码转换结果实体为String类型
			body = EntityUtils.toString(entity, "UTF-8");
		}
		EntityUtils.consume(entity);
		//释放链接
		response.close();
		return body;
	}

	static final String schema="WECHATPAY2-SHA256-RSA2048";


	public static String sendVXJson(String url, String json) throws IOException {
		String body = "";
		//创建httpclient对象
		CloseableHttpClient client = HttpClients.createDefault();
		//创建post方式请求对象
		HttpPost httpPost = new HttpPost(url);
		//装填参数
		StringEntity s = new StringEntity(json, "utf-8");
		s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
				"application/json"));
		//设置参数到请求对象中
		httpPost.setEntity(s);
		//设置header信息
		//指定报文头【Content-type】、【User-Agent】
		httpPost.setHeader("Accept","*/*");
		httpPost.setHeader("Content-type", "application/json");
		httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

		//执行请求操作，并拿到结果（同步阻塞）
		CloseableHttpResponse response = client.execute(httpPost);
		//获取结果实体
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			//按指定编码转换结果实体为String类型
			body = EntityUtils.toString(entity, "UTF-8");
		}
		EntityUtils.consume(entity);
		//释放链接
		response.close();
		return body;
	}


	public static void main(String[] args) throws IOException {

		String data="<?xml version='1.0' encoding='GBK'?><Package><Header><RequestType /><SystemNo /><SendTime>2019-08-29 09:56:17</SendTime><Status>100</Status><ErrorMessage /></Header><Sign>n3Eixx3QKCoqWMpmjRZw+kWj53RyeNKs2eDis8+i6rA6P2z6PPTZEXR3/wDdhgZ5qHCPwr/Tg+mv\n" +
				"8KE7aLYHjtcljRdCGdwAh4229WxzvmbHmvtOhWl6U0pDw/yQXItLUS6NRnex2lU6ab5FJUbkEZxC\n" +
				"FcDJUFhEmcWKPo1qWNU=</Sign><Response><DepartmentCode>5</DepartmentCode><TransSourceCode>0</TransSourceCode><PayNo /><PayAmount>192</PayAmount><PayDiscount /><RealPayAmount>192</RealPayAmount><PaymentTime>2019-08-29 09:54:40</PaymentTime><DealTime>Thu Aug 29 09:54:40 CST 2019</DealTime><PayType>1</PayType><PlatformCode>37</PlatformCode><PlatformName /><BankApplyCode /><BankName /><PayerAccount /><VoucherNo /><OrderId>1000000000494548</OrderId><OrderStatus>2</OrderStatus><PageUrl>https://sit-ecsalefront.axa.cn/payResult.do</PageUrl><NotifyUrl>https://sit-ecsalefront.axa.cn/payJobResult.do</NotifyUrl><IsRenewal /><AutoErrMsg /><BusinessTypeDetail /><BusinessType /><OpenId /><PaymentMode /><RealPaymentMode /><EcsaleSubOrderId /><SubOrderAmount /><ProductList><Product><ProductId>H0900519082802655558</ProductId><ApplyPolicyNo /><PolicyNo /><ProductName>“卓越守护”百万住院医疗保险经济款个人计划</ProductName><ProductAmt>192</ProductAmt><ProductType>2</ProductType><IsVerify /><ViewProductUrl /><InsuranceBeginTime /><InsuranceEndTime /><BatchDetailNo /><CbcDetailNo /><PlanCode>H09</PlanCode><ProductNameEn /></Product></ProductList></Response></Package>";


		String body = "";
		//创建httpclient对象
		CloseableHttpClient client = HttpClients.createDefault();
		//创建post方式请求对象
		HttpPost httpPost = new HttpPost("http://yangsongxiao.cn/Web/Web");
		//HttpPost httpPost = new HttpPost("http://127.0.0.1/Web/Web");
		//装填参数
		StringEntity s = new StringEntity(data, "GBK");
		s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
				"GBK"));
		//设置参数到请求对象中
		httpPost.setEntity(s);
		//设置header信息
		//指定报文头【Content-type】、【User-Agent】
		httpPost.setHeader("Accept","*/*");
		httpPost.setHeader("Content-type", "text/xml");
		httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		//执行请求操作，并拿到结果（同步阻塞）
		CloseableHttpResponse response = client.execute(httpPost);
		//获取结果实体
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			//按指定编码转换结果实体为String类型
			body = EntityUtils.toString(entity, "UTF-8");
		}
		EntityUtils.consume(entity);
		//释放链接
		response.close();
		System.out.println(body);
	}
}
