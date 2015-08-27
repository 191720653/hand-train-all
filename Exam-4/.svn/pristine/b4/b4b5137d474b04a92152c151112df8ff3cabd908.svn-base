package com.hand.Exam4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		Random random = new Random(1);
		List<Integer> list = new ArrayList<Integer>();
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		
		System.out.print("随机生成50个小于100的数，分别为：");
		for (int i = 0; i < 50; i++) {
			int temp = (int) (random.nextFloat() * 100);
			list.add(temp);
			System.out.print(temp+",");
		}
		System.out.println();

		for (int j = 0; j < 17; j++) {
			List<Integer> listTemp = new ArrayList<Integer>();
			for (int i = j * 3; i < (j + 1) * 3; i++) {
				if (j == 16 && i == 50) {
					break;
				}
				int temp = list.get(i) / 10;
				listTemp.add(temp);
			}
			map.put(j, listTemp);
		}
		System.out.println("Map中的数据为："+map);

		for (int i = 0; i < map.size(); i++) {
			List<Integer> listTemp = map.get(i);
			Collections.sort(listTemp);
			map.put(i, listTemp);

		}

		System.out.println("排序后的map为："+map);

	}
}
