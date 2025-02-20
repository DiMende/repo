import java.util.ArrayList;
import exceptions.notation.*;

public class MyQueue<T> implements QueueInterface<T> {
	
	private int size;
	private int currIndex;
	private T[] queue;
	
	@SuppressWarnings("unchecked")
	public MyQueue (int size1) {
		size1 = size;
		T[] tempQueue = (T[]) new Object[size];
		queue = tempQueue;
	}
	
	@SuppressWarnings("unchecked")
	public MyQueue() {
		size = 10;
		T[] tempQueue = (T[]) new Object[size];
		queue = tempQueue;
	}
	

	@Override
	public boolean isEmpty() {
		
		return false; 
		
	}
	
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String toString(){
		return null;
	}

	@Override
	public String toString(String delimiter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fill(ArrayList<T> list) throws QueueOverflowException{
		// TODO Auto-generated method stub
		
	}
	
	
}
