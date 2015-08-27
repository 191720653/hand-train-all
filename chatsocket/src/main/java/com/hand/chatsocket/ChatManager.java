package com.hand.chatsocket;

import java.util.Vector;

public class ChatManager {

	private ChatManager() {
	}

	private static final ChatManager chatManager = new ChatManager();

	public static ChatManager getChatManager() {
		return chatManager;
	}

	Vector<ChatSocket> vector = new Vector<ChatSocket>();

	public void add(ChatSocket chatSocket) {
		vector.add(chatSocket);
	}

	public void publish(ChatSocket chatSocket, String out) {
		try {
			for (int i = 0; i < vector.size(); i++) {
				ChatSocket chatSocket2 = vector.get(i);
				if (!chatSocket.equals(chatSocket2)) {
					chatSocket2.out(out + "\n");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("有客戶端斷開連接！");
		}
	}

}
