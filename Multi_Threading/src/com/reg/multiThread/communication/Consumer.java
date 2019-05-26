package com.reg.multiThread.communication;

import java.util.List;

public class Consumer implements Runnable {
	List<Integer> products;

	public Consumer(List<Integer> products) {
		this.products = products;
	}

	TestAPP t = new TestAPP();

	public void Consuming() throws InterruptedException {
		while (true) {
			synchronized (products) {
				if (products.size() == 0) {
					System.out.println("Consumer Waiting for Producer Response -- " + t.getCurrentTime());
					products.wait();
				} else {
					int con_prod = products.remove(0);
					System.out.println("Consumed Product: " + con_prod + " at " + t.getCurrentTime());
					products.notify();
					System.out.println("Notifying to Producer -- Consumed Product -- at " + t.getCurrentTime() + "\n");
					if (con_prod == 100) {
						System.out.println("Business Closed for Today");
						break;
					}
				}

			}
		}
	}

	@Override
	public void run() {
		try {
			Consuming();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
