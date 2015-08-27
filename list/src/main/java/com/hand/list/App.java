package com.hand.list;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Properties;
import java.util.Queue;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.out.println("Hello World!");

		HashMap<String, String> hashMap = new HashMap<String, String>();

		hashMap.put("a", "one");
		hashMap.put("b", "two");
		hashMap.put("c", "three");
		hashMap.put("d", "four");
		hashMap.put("e", "five");

		System.out.println(hashMap);

		if (hashMap.containsKey("d")) {
			System.out.println("hashMap.containsKey(\"d\"): " + hashMap.containsKey("d"));
		}
		if (hashMap.containsValue("three")) {
			System.out.println("hashMap.containsValue(\"three\"): " + hashMap.containsValue("three"));
		}

		Set<String> set = hashMap.keySet();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		Queue<String> queue = new PriorityQueue<String>();
		queue.offer("c");
		queue.offer("b");
		queue.offer("a");
		System.out.println(queue);

		queue.clear();

		queue = new ArrayDeque<String>();
		queue.offer("c");
		queue.offer("b");
		queue.offer("a");
		System.out.println(queue);

		Properties properties = new Properties();
		properties.setProperty("c", "three");
		properties.setProperty("a", "one");
		properties.setProperty("b", "two");
		System.out.println(properties.toString());
		properties.store(new FileOutputStream("properties.ini"), "comment line");

		Properties properties2 = new Properties();
		properties2.setProperty("hehe", "haha");
		properties2.load(new FileInputStream("properties.ini"));
		System.out.println(properties2);

		System.out.println("The end!");
	}
}
