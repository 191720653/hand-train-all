/**
 * 
 */
package com.hand.chatsocket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @author zehao
 *
 */
public class ChatSocket extends Thread {

	Socket socket;

	public ChatSocket(Socket socket) {
		this.socket = socket;
	}

	public void out(String out) {
		try {
			socket.getOutputStream().write(out.getBytes("UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("有客户端断开连接！");
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// super.run();

		// try {
		// // BufferedWriter bufferedWriter = new BufferedWriter(new
		// // OutputStreamWriter(socket.getOutputStream()));
		// int count = 0;
		// while (true) {
		// // block
		// // bufferedWriter.write("loop:"+(++count));
		// out("loop:" + (++count));
		// sleep(1000);
		// }
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } finally {
		// System.out.println("The End!");
		// }

		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				ChatManager.getChatManager().publish(this, line);
			}
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("有客户端断开连接！");
		}

	}

	/**
	 * @param args
	 */
	// public static void main(String[] args) {
	// // TODO Auto-generated method stub
	//
	// }

}
