package com.hand.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Get extends Thread {

	HttpClient httpClient = HttpClients.createDefault();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// super.run();
		HttpGet httpGet = new HttpGet("http://www.baidu.com");
		try {
			HttpResponse httpResponse = httpClient.execute(httpGet);
			HttpEntity httpEntity = httpResponse.getEntity();
			String result = EntityUtils.toString(httpEntity, "UTF-8");
			System.out.println(result);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			System.out.println("The End!");
		}
	}

	public static void main(String args[]) {
		new Get().start();
	}
}
