/*
 * package com.anurag.test.example;
 * 
 * class Node { int value; Node next;
 * 
 * public Node(int value) { this.value = value; } }
 * 
 * class linkedList { private Node head;
 * 
 * public linkedList() { }
 * 
 * public void insertAtBegning(int data) { Node node = new Node(data); node.next
 * = head; head = node; }
 * 
 * public void insertAtLast(int data) { Node node = new Node(data); if (head ==
 * null) { node.next = head; head = node; return; } Node current = head; while
 * (current.next != null) { current = current.next; }
 * 
 * current.next = node;
 * 
 * }
 * 
 * public void delete(int data) { if (head == null) { return; } if (head.value
 * == data) { head = head.next; } Node current = head; while (current.next !=
 * null) { if (current.next.value == data) { current.next = current.next.next; }
 * } }
 * 
 * public void display() { Node current = head; while(current!=null) {
 * System.out.println(current.value); current = current.next; } }
 * 
 * }
 * 
 * public class LinkedListExample { public static void main(String[] args) {
 * 
 * linkedList linkedList = new linkedList(); linkedList.insertAtBegning(1);
 * linkedList.insertAtBegning(12); linkedList.insertAtBegning(14);
 * linkedList.insertAtBegning(15); linkedList.insertAtBegning(18);
 * linkedList.display();
 * 
 * 
 * } }
 */