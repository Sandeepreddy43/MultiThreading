package com.reg.multiThread.communication;

import java.util.List;

public class Producer implements Runnable {
	List<Integer> products;

	public Producer(List<Integer> products) {
		this.products = products;
	}

	TestAPP t = new TestAPP();

	public void Producing() throws InterruptedException {
		for (int i = 10; i <= 100; i += 5) {
			synchronized (products) {
				if (products.size() == 5) {
					products.wait();
					Thread.sleep(100);
					System.out.println("Producer Waiting for Consumer Status-- " + t.getCurrentTime());
				} else {
					products.add(i);
					int prod = products.get(products.size() - 1);
					System.out.println("Produced Product: " + prod + " at " + t.getCurrentTime());
					products.notify();
					System.out.println("Producer Notifying to Consumer -- " + t.getCurrentTime());
				}
			}
			Thread.sleep(1000);
		}
	}

	@Override
	public void run() {
		try {
			Producing();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
