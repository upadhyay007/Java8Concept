package com.anurag.thread.example;

public class TwoThreadToPrint {
	static int count = 0;
	static TwoThreadToPrint object = new TwoThreadToPrint();

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			synchronized (object) {
				while (count < 10) {
					if (count % 2 == 0) {
						try {
							object.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println(Thread.currentThread().getName() + "->" + count);
					count++;
					object.notifyAll();
				}
			}
		}, "Thread-1");

		Thread t2 = new Thread(() -> {
			synchronized (object) {
				while (count < 10) {

					if (count % 2 != 0) {
						try {
							object.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println(Thread.currentThread().getName() + "->" + count);
					count++;
					object.notifyAll();
				}
			}
		}, "Thread-2");

		t1.start();
		t2.start();
	}

}
