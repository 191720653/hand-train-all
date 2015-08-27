package com.hand.socket;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Server {

	private ServerSocket serverSocket;

	private List<Socket> list;

	public Server(ServerSocket serverSocket, List<Socket> list) {
		this.serverSocket = serverSocket;
		this.list = list;
	}

	public static void main(String args[]) throws IOException {
			
			Server server = new Server(new ServerSocket(12345), new ArrayList<Socket>());
			
			server.accept();
			server.say();

	}

	public synchronized ServerSocket getServerSocket() {
		return serverSocket;
	}

	public void say() {
		new Thread() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				// super.run();
				Scanner scanner = new Scanner(System.in);
				while (true) {
					System.out.println("请输入要发送的通知：");
					String content = scanner.nextLine();
					synchronized (list) {
						System.out.println(list.size());
						for (int i = 0; i < list.size(); i++) {
							Socket socket = list.get(i);
							try {
								System.out.println(content);
								socket.getOutputStream().write(content.getBytes("UTF-8"));
							} catch (UnsupportedEncodingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}

				}
			}

		}.start();
	}

	public void accept() {
		new Thread() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				// super.run();
				while (true) {
					Socket socket = null;
					try {
						socket = serverSocket.accept();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (list) {
						list.add(socket);
					}
					JOptionPane.showMessageDialog(null, "欢迎您的访问！");
				}
			}

		}.start();
	}

}
