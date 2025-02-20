import java.util.ArrayList;
import exceptions.notation.*;

public class MyStack<T> implements StackInterface<T>{
	
	private int size;
	private int currIndex;
	private Node head;
	
	private class Node{
		private T data;
		private Node next;
		private Node(T dataPortion) {
			this(dataPortion,null);
		}
		
		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}
	}
	
	@SuppressWarnings("unchecked")
	public MyStack(int size) {
		
		this.size = size;
		head = null;
		currIndex = 0;
		
	}
	
	@SuppressWarnings("unchecked")
	public MyStack() {
		size = 10;
		head = null;
		currIndex = 0;
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T pop() throws StackUnderflowException {
		
		return null;
	}

	@Override
	public T top() throws StackUnderflowException {
		if()
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean push(T e) throws StackOverflowException {
		
		if(currIndex < size) {
			Node temp = new Node(e);
			temp.next = head;
			head = temp;
			currIndex++;
			return true;
		}
		
		throw new StackOverflowException();
	}
	
	@Override
	public String toString() {
		
		return null;
	}

	
	@Override
	public String toString(String delimiter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fill(ArrayList<T> list) {
		// TODO Auto-generated method stub
		
	}
	
	

}
