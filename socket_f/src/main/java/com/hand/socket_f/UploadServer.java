package com.hand.socket_f;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.portable.OutputStream;

import com.google.gson.Gson;

public class UploadServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ServerSocket serverSocket = new ServerSocket(12345);
		List<String> list = new ArrayList<String>();
		int count = 0;
		while (true) {
			count++;
			Socket socket = serverSocket.accept();
			System.out.println("开始上传文件......");
			InputStream inputStream = socket.getInputStream();
			BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(count + ".txt"));
			list.add(count + ".txt");
			byte[] temp = new byte[1024];
			int length = 0;
			while ((length = bufferedInputStream.read(temp)) > 0) {
				bufferedOutputStream.write(temp);
				System.out.println(length);
			}
			java.io.OutputStream outputStream = socket.getOutputStream();
			String files = "上传文件成功！" + "文件列表：" + new Gson().toJson(list);
			outputStream.write(files.getBytes());
			bufferedOutputStream.close();
			bufferedInputStream.close();
			inputStream.close();
			outputStream.close();
		}

	}

}
