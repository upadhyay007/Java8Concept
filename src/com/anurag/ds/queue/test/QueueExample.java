package com.anurag.ds.queue.test;

public class QueueExample {
	Node front;
	Node rear;
	int size;

	public QueueExample() {
		this.front = null;
		this.rear = null;
		this.size = 0;
	}

	public int first() {
		return front.value;
	}

	public int last() {
		return rear.value;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void add(int value) {
		Node node = new Node(value);
		if (isEmpty()) {
			front = node;
		} else {
			rear.next = node;
		}
		rear = node;
		size++;

	}

	public int remove() {
		int value = front.value;
		this.front = front.next;
		if (front == null) {
			this.rear = null;
		}
		size--;
		return value;

	}
	
	public void view() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
		}
		
		Node node = front;
		while(node !=null) {
			System.out.println(node.value);
			node =node.next;	
			
		}
	}
}
