package com.anurag.thread;

import java.util.Queue;

public class Consumer implements Runnable {
	private Queue<Integer> queue;

	public Consumer(Queue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {

		while (true) {
			synchronized (queue) {
				while (queue.size() == 0) {
					try {
						System.out.println("Thread Name -->  " + Thread.currentThread().getName());
						queue.wait();
						Thread.currentThread().sleep(1000);
												
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Integer poll = queue.poll();
				System.out.println("Consume #####: " + poll);
				queue.notifyAll();
			}

		}
	}
}
