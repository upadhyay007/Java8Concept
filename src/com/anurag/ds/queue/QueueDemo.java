package com.anurag.ds.queue;

public class QueueDemo {
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.add(12);
		queue.add(20);
		queue.add(22);
		queue.add(89);
		queue.add(90);
		queue.add(102);
		queue.add(1);

		queue.view();
		queue.deQueue();
		queue.view();
		
	}
}
