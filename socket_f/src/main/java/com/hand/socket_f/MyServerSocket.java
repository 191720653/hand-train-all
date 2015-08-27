package com.hand.socket_f;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class MyServerSocket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//1-65535
			ServerSocket serverSocket = new ServerSocket(12345);
			//block
			Socket socket = serverSocket.accept();
			//建立连接
			JOptionPane.showMessageDialog(null, "欢迎您的访问！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("The End!");
		}

	}

}
