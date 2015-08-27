package com.hand.http;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

//import org.w3c.dom.Document;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.w3c.dom.Node;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException, TransformerException, DocumentException {
		System.out.println("Hello World!");

		URL url = new URL(
				"http://fanyi.youdao.com/openapi.do?keyfrom=ZHENGZEHAO&key=824503963&type=data&doctype=xml&version=1.1&q=welcome");

		URLConnection urlConnection = url.openConnection();
		InputStream inputStream = urlConnection.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		String line;
		StringBuilder stringBuilder = new StringBuilder();
		while ((line = bufferedReader.readLine()) != null) {
			stringBuilder.append(line);
		}

		 Document document = DocumentHelper.parseText(new
		 String(stringBuilder));
		// TransformerFactory transformerFactory =
		// TransformerFactory.newInstance();
		// Transformer transformer = transformerFactory.newTransformer();
		// transformer.transform(new DOMSource((Node)document), new
		// StreamResult(new File("xml.xml")));
		 OutputFormat outputFormat = OutputFormat.createPrettyPrint();
		 outputFormat.setEncoding("UTF-8");
		 XMLWriter xmlWriter = new XMLWriter(new FileWriter("reuslt.xml"), outputFormat);
		 xmlWriter.write(document);
		 xmlWriter.close();

		bufferedReader.close();
		inputStreamReader.close();
		inputStream.close();

		System.out.println(new String(stringBuilder));

		// <?xml version="1.0" encoding="UTF-8"?><youdao-fanyi>
		// <errorCode>0</errorCode>
		// <query><![CDATA[welcome]]></query>
		// <translation>
		// <paragraph><![CDATA[欢迎]]></paragraph>
		// </translation></youdao-fanyi>

		// {"translation":["欢迎"],"query":"welcome","errorCode":0}
	}
}
