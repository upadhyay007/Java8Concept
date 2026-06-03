package com.anurag.thread.example;

import java.util.Queue;

public class ConsumerExample  implements Runnable{

	private Queue<Integer> queue;
		
	public ConsumerExample(Queue<Integer> queue) {
		super();
		this.queue = queue;
	}


	@Override
	public void run() {
		while(true) {
			synchronized (queue) {
				while(queue.size()==0) {
					try {
						//System.out.println("consume:-> "+ Thread.currentThread().getName());
						queue.wait();
						Thread.currentThread().sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Integer poll = queue.poll();
				System.out.println("Consumed : "+ poll);
				queue.notifyAll();
			}
		}
		
	}

}
