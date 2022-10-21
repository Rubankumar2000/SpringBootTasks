package org.thread;

public class MyThread extends Thread {
//	public void run() {
//		System.out.println("Thread is running...");
//	}
	
	public static void main(String[] args) {
		Thread obj=new Thread(new MyThread());
		obj.start();
	}
}
