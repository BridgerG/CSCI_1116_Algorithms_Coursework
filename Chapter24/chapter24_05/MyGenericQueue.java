package chapter24_05;

import java.util.LinkedList;

public class MyGenericQueue<E> extends LinkedList<E>{
	
	public void enqueue(E e) {
		
		addLast(e);
		
	}
	
	public E dequeue() {
		
		E get = getFirst();
		removeFirst();
		return get;
		
	}
	

	public int size() {
		
		return super.size();
		
	}
}
