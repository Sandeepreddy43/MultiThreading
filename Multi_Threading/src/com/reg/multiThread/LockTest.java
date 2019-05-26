package com.reg.multiThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest implements Runnable {
	Lock lock = new ReentrantLock();

	public synchronized void lock_test() throws InterruptedException {
		lock.lock();
		//Semaphore sem = new Semaphore(3);
		//sem.acquire(3);
		
		for (int i = 0; i < 5; i++) {
			Thread.sleep(1000);
			System.out.println("Lock --- "+(i+1)+" "+Thread.currentThread().getName());
		}
		System.out.println("Out Side - For loop");
		Thread.sleep(2000);
		//sem.release(1);
		lock.unlock();
		System.out.println("Unlock --- "+Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		LockTest l = new LockTest();		
		Thread T1 = new Thread(l);
		Thread T2 = new Thread(l);
		Thread T3 = new Thread(l);
		Thread T4 = new Thread(l);
		Thread T5 = new Thread(l);
		Thread T6 = new Thread(l);
		T1.start();
		T2.start();
		T3.start();
		T4.start();
		T5.start();
		T6.start();
	}

	@Override
	public void run() {
		try {
			lock_test();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}