package com.anurag.thread.practice;

public class PracticeThreadPrintEvenOdd {
	public static int Count =0;
	PracticeThreadPrintEvenOdd evenOdd = new PracticeThreadPrintEvenOdd();

}

class ThreadEven implements Runnable{
	int count;
	PracticeThreadPrintEvenOdd evenOdd;
	
	public ThreadEven(int c,PracticeThreadPrintEvenOdd evenOdd) {
		this.count=c;
		this.evenOdd = evenOdd;
	}
	 @Override
	public void run() {
		 while(count<=10) {
			 synchronized (evenOdd) {
				
			}
		 }
		
	}
}

class ThreadOdd implements Runnable{
	int count;
	
	public ThreadOdd(int count) {
		this.count = count;
	}

	@Override
	public void run() {
		
	}
	
}