package com.hand.socket_f;

import java.awt.FileDialog;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UPloadClient {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		// C:\HaxLogs.txt
		while (true) {
			System.out.println("请输入要上传文件的路径：");
			String path = scanner.nextLine();
			BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
			Socket socket = new Socket("127.0.0.1", 12345);
			OutputStream outputStream = socket.getOutputStream();
			byte[] temp = new byte[1024];
			int length = 0;
			while ((length = bufferedInputStream.read(temp)) > 0) {
				outputStream.write(temp, 0, length);
			}
			socket.shutdownOutput();
			System.out.println("上传结束！");
			
			InputStream inputStream = socket.getInputStream();
			temp = new byte[1024];
			length = inputStream.read(temp);
			String result = new String(temp, 0, length);
			System.out.println("服务器端返回的信息：" + result);

			bufferedInputStream.close();
			outputStream.close();
			inputStream.close();

		}

	}

}
