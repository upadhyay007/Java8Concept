package com.anurag.thread;

//Print even and odd from two different thread 
public class PrintEvenOddUsing2Thread {
	static int count = 1;
	static PrintEvenOddUsing2Thread evenOddUsingThread = new PrintEvenOddUsing2Thread();

	public static void main(String[] args) {
		// Thread 1
		Thread t = new Thread(() -> {
			synchronized (evenOddUsingThread) {
				while (count < 10) {
					if (count % 2 == 0) {
						try {
							evenOddUsingThread.wait();
						} catch (InterruptedException e) {
						}
					}
					System.out.println(Thread.currentThread().getName() + "-> " + count);
					count++;
					evenOddUsingThread.notifyAll();
				}
			}

		}, "Thread-1");

		// Thread 2
		Thread t1 = new Thread(() -> {
			synchronized (evenOddUsingThread) {
				while (count < 10) {
					if (count % 2 != 0) {
						try {
							evenOddUsingThread.wait();
						} catch (InterruptedException e) {
						}
					}
					System.out.println(Thread.currentThread().getName() + "-> " + count);
					count++;
					evenOddUsingThread.notifyAll();
				}
			}

		}, "Thread-2");

		t.start();
		t1.start();

	}
}
