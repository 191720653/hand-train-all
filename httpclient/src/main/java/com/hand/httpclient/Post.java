package com.hand.httpclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class Post extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Post().start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// super.run();

//		try {
//			HttpClient client = HttpClients.createDefault();
//			HttpPost httpPost = new HttpPost("http://www.baidu.com");
//			HttpResponse httpResponse = client.execute(httpPost);
//			HttpEntity httpEntity = httpResponse.getEntity();
//			String result;
//			result = EntityUtils.toString(httpEntity, "UTF-8");
//			System.out.println(result);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			System.out.println("The End!");
//		}

		// keyfrom=ZHENGZEHAO&key=824503963&type=data&doctype=xml&version=1.0&
		// q=welcome

		HttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://fanyi.youdao.com/openapi.do");
		List<BasicNameValuePair> entity = new ArrayList<BasicNameValuePair>();
		entity.add(new BasicNameValuePair("keyfrom", "ZHENGZEHAO"));
		entity.add(new BasicNameValuePair("key", "824503963"));
		entity.add(new BasicNameValuePair("type", "data"));
		entity.add(new BasicNameValuePair("doctype", "xml"));
		entity.add(new BasicNameValuePair("version", "1.1"));
		entity.add(new BasicNameValuePair("q", "welcome"));
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(entity, "UTF-8"));
			HttpResponse httpResponse = client.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			String result = EntityUtils.toString(httpEntity, "UTF-8");
			System.out.println(result);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("The End!");
		}

	}

}
