package com.reg.multiThread;

public class Multi_Thread_TestAPP {
	public static void main(String[] args) {

		MultiThreadingDemo mt = new MultiThreadingDemo();
		Thread T1 = new Thread(mt);
		Thread T2 = new Thread(mt);
		Thread T3 = new Thread(mt);
		T1.start();
		T2.start();
		T3.start();
	}
}
