package com.anurag.thread.example;

import java.util.Queue;

public class ProducerExample implements Runnable {
	private Queue<Integer> queue;

	public ProducerExample(Queue<Integer> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		for(int i=0; i<24; i++) {
			synchronized (queue) {
				while(queue.size()>=1) {
					try {
						Thread.currentThread().sleep(1000);
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}								
				}
				queue.add(i);
				System.out.println("Producer Produce : "+ i);
				queue.notifyAll();
			}
		}

	}

}
