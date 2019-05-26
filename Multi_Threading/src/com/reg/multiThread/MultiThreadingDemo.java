package com.reg.multiThread;

public class MultiThreadingDemo implements Runnable {

	public synchronized void test(){
		for(int i= 0; i<5; i++){
			System.out.println("Thread: "+Thread.currentThread().getName()+" i value: "+i);
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	volatile int s=0;
	String s2;
	public void testVolatile(){
		for(s=1; s < 5; s++){
			test();
			System.out.println("Volatile: "+s+1);
		}
		for(int i = 0; i < 5; i++){
			System.out.println("Non - Volatile: "+i+1);
		}
	}
	
	@Override
	public void run() {
		
		testVolatile();
	}

}
