package com.hand.http;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class App2 {

	public static void main(String[] args) throws IOException {

		URL url = new URL("http://fanyi.youdao.com/openapi.do");
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.addRequestProperty("encoding", "UTF-8");
		httpURLConnection.setDoInput(true);
		httpURLConnection.setDoOutput(true);
		httpURLConnection.setRequestMethod("POST");

		OutputStream outputStream = httpURLConnection.getOutputStream();
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
		BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

		bufferedWriter.write("?keyfrom=ZHENGZEHAO&key=824503963&type=data&doctype=xml&version=1.0&q=welcome");
		bufferedWriter.flush();

		InputStream inputStream = httpURLConnection.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		String line;
		StringBuilder stringBuilder = new StringBuilder();
		while ((line = bufferedReader.readLine()) != null) {
			stringBuilder.append(line);
		}
		System.out.println(new String(stringBuilder));

		bufferedReader.close();
		bufferedWriter.close();
		inputStreamReader.close();
		inputStream.close();
		outputStreamWriter.close();
		outputStream.close();

	}

}
