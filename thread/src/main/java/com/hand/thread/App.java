package com.hand.thread;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilterReader;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		// test test = new test("This is thread1!");
		// test test2 = new test("This is thread2!");
		//
		// Thread thread1 = new Thread(new MyThread("肥民", test));
		//
		// Thread thread2 = new Thread(new MyThread("小紅", test));
		//
		// thread1.setPriority(Thread.MIN_PRIORITY);
		// thread2.setPriority(Thread.MAX_PRIORITY);
		//
		// thread1.start();
		//
		// thread2.start();

		FileThread fileThread = new FileThread("one");

		FileThread fileThread2 = new FileThread("two");

		FileThread fileThread3 = new FileThread("three");

		Thread thread = new Thread(fileThread);

		Thread thread2 = new Thread(fileThread2);

		Thread thread3 = new Thread(fileThread3);

		thread.start();

		thread2.start();

		thread3.start();

	}
}

class MyThread implements Runnable {

	private String name = "默認沒有，請修改！";

	private test test = null;

	public MyThread(String name, test test) {
		this.name = name;
		this.test = test;
	}

	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(500);
				test.method();
				// System.out.println("線程名："+name+"\t"+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

class test {
	private String say;

	public test(String say) {
		this.say = say;
	}

	public synchronized void method() {
		System.out.println(say);
	}
}

class FileThread implements Runnable {

	private String name = "";

	private File file = new File("zehao.txt");

	public FileThread(String name) {
		this.name = name;
		if (file.exists()) {
			System.out.println("文件已经存在！");
		} else {
			System.out.println("文件不存在！");
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("文件创建成功！");
		}
	}

	public void run() {
		// TODO Auto-generated method stub
		RandomAccessFile randomAccessFile;
		try {
			randomAccessFile = new RandomAccessFile(file, "rw");
			for (int i = 0; i < 5; i++) {
				randomAccessFile.seek(i * 10);
				byte[] temp = new byte[10];
				randomAccessFile.read(temp);
				System.out.println(name + "\t" + new String(temp));
				Thread.sleep(200);
				// randomAccessFile.writeBytes(name + "\t" + i + "\n");
			}
			System.out.println(name + "写入数据完毕！");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
