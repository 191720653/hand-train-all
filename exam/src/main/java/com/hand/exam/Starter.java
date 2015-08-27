package com.hand.exam;

public class Starter extends Thread {

//	 private int x=2;
//	
//	 public static void main(String args[]) throws Exception{
//	 new Starter().make();
//	 }
//	
//	 public Starter(){
//	 x=5;
//	 start();//执行run方法
//	 }
//	
//	 public void make() throws InterruptedException{
//	 join();//阻塞调用线程
//	 x=x+1;
//	 System.out.println(x);
//	 }
//	
//	 public void run(){
//	 x=x*2;
//	 }

	// -------------------------------------------------------

//	 public void go(){
//	 Runnable r = new Runnable() {
//	
//	 public void run() {
//	 // TODO Auto-generated method stub
//	 System.out.println("foo");
//	 }
//	 };
//	 Thread t = new Thread(r);
//	 t.start();//start()不能连续调用
//	 t.start();
//	 }
//	
//	 public static void main(String args[]){
//	 new Starter().go();
//	 }

	// -------------------------------------------------------

//	public static void main(String args[]) {
//		Runnable r = new Runnable() {
//
//			public void run() {
//				// TODO Auto-generated method stub
//				System.out.println("cat");
//			}
//		};
//		Thread t = new Thread(r) {
//			public void run() {// 此处覆盖了runable中的run方法
//				System.out.println("dog");
//			}
//		};
//		t.start();
//	}
}
