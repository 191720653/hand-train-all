package com.hand.Exam2;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		System.out.print("请输入工资：");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		if (num <= 3500) {
			System.out.println("工资低于3500，不用缴纳税费！");
		} else {
			num = num - 3500;
			double out = 0;

			if (num <= 1500) {
				out = num * 0.03;
			} else if (num <= 4500) {
				out = num * 0.1;
			} else if (num <= 9000) {
				out = num * 0.2;
			} else if (num <= 350000) {
				out = num * 0.25;
			} else if (num <= 55000) {
				out = num * 0.3;
			} else if (num <= 80000) {
				out = num * 0.35;
			} else {
				out = num * 0.45;
			}

			System.out.println("所需要缴纳的税费为：" + out + "元");
		}

	}
}
