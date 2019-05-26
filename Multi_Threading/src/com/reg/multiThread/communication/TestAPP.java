package com.reg.multiThread.communication;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestAPP {
	public String getCurrentTime(){
		Date today = new Date();
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd / HH:mm:ss").format(today);
		return timeStamp;
		}
	public static void main(String[] args) throws InterruptedException {
	List<Integer> products = new ArrayList<>();
	Thread producer = new Thread(new Producer(products));
	Thread consumer = new Thread(new Consumer(products)); 
	producer.start();
	consumer.start();
	}
}
