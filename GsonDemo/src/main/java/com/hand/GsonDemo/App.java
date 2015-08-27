package com.hand.GsonDemo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * json数据操作
 * 
 * @author zehao
 *
 */
public class App {
	public static void main(String[] args) throws JsonIOException, JsonSyntaxException, IOException {

		System.out.println("Hello Json!");

		// 读取test.json文件的json数据
		JsonParser jsonParser = new JsonParser();

		JsonObject jsonObject = (JsonObject) jsonParser.parse(new FileReader("test.json"));

		System.out.println(jsonObject);

		System.out.println("--------------------------");

		System.out.println("cat: " + jsonObject.get("cat"));
		System.out.println("pop: " + jsonObject.get("pop"));

		JsonArray jsonArray = jsonObject.getAsJsonArray("lan");

		for (int i = 0; i < jsonArray.size(); i++) {

			System.out.println("--------------------------");

			JsonObject temp = (JsonObject) jsonArray.get(i);

			System.out.println("id: " + temp.get("id"));
			System.out.println("name: " + temp.get("name"));
			System.out.println("ide: " + temp.get("ide"));
		}

		// 创建new.json文件
		JsonObject root = new JsonObject();

		root.addProperty("cat", "it");
		root.addProperty("pop", true);

		JsonArray lan = new JsonArray();

		JsonObject java = new JsonObject();
		java.addProperty("id", 1);
		java.addProperty("name", "Java");
		java.addProperty("ide", "Eclipse");

		lan.add(java);

		JsonObject cSharp = new JsonObject();
		cSharp.addProperty("id", 2);
		cSharp.addProperty("name", "C#");
		cSharp.addProperty("ide", "Visual Studio");

		lan.add(cSharp);

		JsonObject switf = new JsonObject();
		switf.addProperty("id", 3);
		switf.addProperty("name", "Switf");
		switf.addProperty("ide", "XCode");

		lan.add(switf);

		root.add("lan", lan);

		Gson gson = new Gson();
		FileWriter fileWriter = new FileWriter(new File("new.json"));
		gson.toJson(root, fileWriter);
		fileWriter.flush();
		fileWriter.close();

		System.out.println(root);

		// 从普通对象转换为json对象
		Person person = new Person("郑泽豪", 21, new int[] { 123, 456, 789 });
		String result = gson.toJson(person);
		System.out.println(result);

		// 从json转换为普通对象
		Person person2 = gson.fromJson(result, Person.class);
		System.out.println("name: " + person2.getName());
		System.out.println("phone: " + person2.getAge());

		System.out.println("The end!");
	}
}
