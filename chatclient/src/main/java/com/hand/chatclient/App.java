package com.hand.chatclient;

import java.awt.EventQueue;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				MainWindow frame = new MainWindow();
				frame.setVisible(true);
				ChatManager.getCM().setWindow(frame);

			}
		});

	}
}
