package com.hand.Exam3;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		boolean sign = true;
		while (sign) {
			System.out.print("请输入日期：");

			Scanner scanner = new Scanner(System.in);

			String date = scanner.nextLine();

			String str[] = date.split("-");
			int temp[] = new int[str.length];

			try {
				for (int i = 0; i < str.length; i++) {
					temp[i] = Integer.parseInt(str[i]);
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("你输入的日期格式不对！");
				continue;
			}

			int num = 0;
			int second = temp[0] % 4 == 0 ? 29 : 28;
			switch (temp[1]) {
			case 1:
				num = num + temp[2];
				break;
			case 2:
				num = num + temp[2] + 31;
				break;
			case 3:
				num += temp[2] + 31 + second;
				break;
			case 4:
				num += temp[2] + 31 + second + 31;
				break;
			case 5:
				num += temp[2] + 31 + second + 31 + 30;
				break;
			case 6:
				num += temp[2] + 31 + second + 31 + 30 + 31;
				break;
			case 7:
				num += temp[2] + 31 + second + 31 + 30 + 31 + 30;
				break;
			case 8:
				num += temp[2] + 31 + second + 31 + 30 + 31 + 30 + 31;
				break;
			case 9:
				num += temp[2] + 31 + second + 31 + 30 + 31 + 30 + 31 + 30;
				break;
			case 10:
				num += temp[2] + 31 + second + 31 + 30 + 31 + 30 + 31 + 30 + 31;
				break;
			case 11:
				num += temp[2] + 31 + second + 31 + 30 + 31 + 30 + 31 + 30 + 31 + 30;
				break;
			case 12:
				num += temp[2] + 31 + second + 31 + 30 + 31 + 30 + 31 + 30 + 31 + 30 + 31;
				break;
			default:
				break;
			}

			System.out.println("你输入的日期为当年的第" + num + "天");

			System.out.println("输入0关闭程序，输入其他继续：");
			int log = scanner.nextInt();
			sign = log == 0 ? false : true;
		}

	}
}
