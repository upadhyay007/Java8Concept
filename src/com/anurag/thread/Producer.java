package com.anurag.thread;

import java.util.Queue;

public class Producer implements Runnable {

	private final Queue<Integer> queue;

	public Producer(Queue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 22; i++) {
			synchronized (queue) {
				while (queue.size() >= 1) {
					try {
						System.out.println("Queue is full !!");
						Thread.currentThread().sleep(1000);
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Producing ..." + i);
				queue.add(i);
				queue.notifyAll();
			}
		}
	}

}
