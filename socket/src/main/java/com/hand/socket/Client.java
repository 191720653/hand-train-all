package com.hand.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String args[]) {
		new Thread() {

			@Override
			public void run() {
				try {
					Socket socket = new Socket("127.0.0.1", 12345);
					PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

					BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String line;
					while ((line = reader.readLine()) != null) {
						// window.appendText("收到："+line);
						System.out.println("收到：" + line);
					}
					writer.close();
					reader.close();
					writer = null;
					reader = null;
					System.out.println("The End!");
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

}
