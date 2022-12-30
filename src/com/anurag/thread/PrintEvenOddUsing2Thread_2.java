package com.anurag.thread;

//Print even and odd from two different thread 
public class PrintEvenOddUsing2Thread_2 {
	static int count = 1;
	static PrintEvenOddUsing2Thread_2 evenOddUsingThread = new PrintEvenOddUsing2Thread_2();
	
	// Thread 1
	static Runnable runnable = () -> {
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

	};

	// Thread 2
	static Runnable runnable2 = () -> {
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

	};

	public static void main(String[] args) {

		Thread t = new Thread(runnable, "Thread-1");
		Thread t1 = new Thread(runnable2, "Thread-2");
		t.start();
		t1.start();

	}
}
