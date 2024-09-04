package com.anurag.thread.practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class PracticeThread {
	public static void main(String[] args) {
		Queue<Integer> integers = new LinkedList<>();
		Thread consumerThread = new Thread(new ConsumerThread(integers),"consumerThread");
		Thread producerThread = new Thread(new ProducerThread(integers),"ProducerThread");
		
		consumerThread.start();
		producerThread.start();
	}
}

class ConsumerThread implements Runnable {
	private Queue<Integer> queue;

	public ConsumerThread(Queue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (queue) {
				while (queue.size() == 0) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					//Thread.sleep(new Random().nextInt(100));
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Integer poll = queue.poll();
				System.out.println(Thread.currentThread().getName()+" consume--> " + poll);
				queue.notifyAll();
			}
		}

	}
}

class ProducerThread implements Runnable {

	private Queue<Integer> queue;

	public ProducerThread(Queue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (queue) {
				while (queue.size() >= 1) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				queue.add(i);
				System.out.println(Thread.currentThread().getName() +"Produce .."+ i + " in queue");
				queue.notifyAll();

			}

		}

	}
}