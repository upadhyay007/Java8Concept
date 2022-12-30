package com.anurag.thread;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerExample {
	public static void main(String[] args) {
		//Shared Queue
		Queue<Integer> queue = new LinkedList<Integer>();
		
		//producer
		Thread producer = new Thread(new Producer(queue));
		
		//Consumer
		Thread consumer = new Thread(new Consumer(queue));
		Thread consumer1 = new Thread(new Consumer1(queue));
		
		producer.start();
		consumer.start();
		consumer1.start();
		
	}
}
