package com.hand.chatsocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerListener extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// super.run();
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(12345);
			while (true) {
				Socket socket = serverSocket.accept();
				// JOptionPane.showMessageDialog(null, "There is someone
				// connecting to the server!");
				socket.getOutputStream().write("你已经连接上服务器！\n".getBytes("UTF-8"));
				System.out.println("There is someone connecting to the server!");
				ChatSocket chatSocket = new ChatSocket(socket);
				chatSocket.start();
				ChatManager.getChatManager().add(chatSocket);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// public static void main(String[] args) {
	// // TODO Auto-generated method stub
	//
	// }

}
