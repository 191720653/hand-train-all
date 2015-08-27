package com.hand.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;

/**
 * Hello world!
 *
 */
public class App {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		System.out.println("Hello World!");

		// File file = new File("zehao.txt");
		//
		// if(file.exists()){
		// System.out.println("文件已經存在！");
		// }else{
		// System.out.println("文件不存在！");
		// file.createNewFile();
		// System.out.println("創建文件成功！");
		// }
		// FileOutputStream fileOutputStream = new FileOutputStream(file);
		// OutputStreamWriter outputStreamWriter = new
		// OutputStreamWriter(fileOutputStream);
		// String str = "肥民你個178！\n這是測試數據！\n";
		// byte[] bt = str.getBytes();
		// outputStreamWriter.write(str);
		// System.out.println("測試數據已經寫入文件！");
		//
		// FileInputStream fileInputStream = new FileInputStream(file);
		// InputStreamReader inputStreamReader = new
		// InputStreamReader(fileInputStream);
		// int temp;
		// char[] input = new char[100];
		// while((temp=inputStreamReader.read(input))!=-1){
		// System.out.println(new String(input));
		// }
		// System.out.println("讀取數據over!");
		//
		// outputStreamWriter.close();
		// inputStreamReader.close();
		// fileInputStream.close();
		// fileOutputStream.close();

		// System.out.println(file.getAbsolutePath());
		// System.out.println(file.getCanonicalPath());

		// File newFile = new File("target/new file.txt");
		//
		// if(newFile.renameTo(file)){
		// System.out.println("移动文件成功！");
		// }else{
		// System.out.println("移动文件失败！");
		// }

//		FileReader fileReader = new FileReader("zehao.txt");
//		BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//		FileWriter fileWriter = new FileWriter("new_zehao.txt");
//		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//
//		String line = "";
//		while ((line = bufferedReader.readLine()) != null) {
//			System.out.println(line);
//			bufferedWriter.write(line + "\n");
//		}
//
//		bufferedWriter.write("测试文件操作完成！");
//
//		bufferedWriter.flush();
//
//		bufferedWriter.close();
//		fileWriter.close();
//		bufferedReader.close();
//		fileReader.close();
		
//		RandomAccessFile randomAccessFile = new RandomAccessFile("raf_zehao.txt", "rw");
//		for(int i=0;i<5;i++){
//			randomAccessFile.seek(i*100);
//			randomAccessFile.writeBytes("this is "+i+"block!\n");
//		}
//		String content = "";
//		for(int i=0;i<5;i++){
//			randomAccessFile.seek(i*100);
//			content=randomAccessFile.readLine();
//			System.out.println(content);
//		}
//		randomAccessFile.close();
		
		File file = new File("../files");
		list(file);
		
		System.out.println("The End!");
	}
	
	public static void list(File file){
		File list[] = file.listFiles();
		for(int i=0;i<list.length;i++){
			if(list[i].isFile()){
				System.out.println(list[i].getName());
			}else{
				list(list[i]);
			}
		}
	}
}
