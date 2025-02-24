import java.util.ArrayList;

import exceptions.notation.*;
/**
 *  A stack list that is implements StackInterface and also implements a link list
 * @author Diego Mendez
 * @param <T>
 */
public class MyStack<T> implements StackInterface<T>{
	
	/**
	 * size is the max size of link list
	 * numOfElements is the number of elements within the link list
	 * head points to the first node of the link list
	 */
	private int size;
	private int numOfElements;
	private Node head;
	
	/**
	 * private class node for link list implementation 
	 */
	private class Node{
		/**
		 * data holds data for the node
		 * next points to the next node 
		 */
		private T data;
		private Node next;
		
		/**
		 * creates a node, passing in data to the node
		 * @param dataPortion
		 */
		private Node(T dataPortion) {
			this(dataPortion,null);
		}
		
		/**
		 * creates a node that has data and points to the next node 
		 * @param dataPortion
		 * @param nextNode
		 */
		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}
	}
	
	/**
	 * Initializes a stack link list array with 
	 * size set by user 
	 * @param size
	 */
	public MyStack(int size) {
		
		this.size = size;
		head = null;
		numOfElements = 0;
		
	}
	/**
	 * Initializes a stack link list array with 
	 * default size of 2
	 * 
	 */
	public MyStack() {
		size = 2;
		head = null;
		numOfElements = 0;
	}

	
	@Override
	public boolean isEmpty() {
		if(head == null) return true;
		return false;
	}

	/**
	 * checks if number of elements in the link list is less than size, if so 
	 * method returns false, true otherwise
	 * @return false if numOfElements is less than size, true otherwise
	 */
	@Override
	public boolean isFull() {
		
		return numOfElements >= size;
	}
	/**
	 * if the link list is not empty, temp holds the current head data,
	 * head points to the next node, and number of elements is decreased by one
	 * @returns first element on top of stack
	 * @throws StackUnderflowException if stack is empty 
	 */
	@Override
	public T pop() throws StackUnderflowException {
		if(!isEmpty()) {
			T temp = head.data;
			head = head.next;
			numOfElements--;
			return temp;
		}
		throw new StackUnderflowException();
	}

	/**
	 * checks the first element of the stack
	 * @return first element of the stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public T top() throws StackUnderflowException {
		
		if(!isEmpty()) {
			return head.data;
		}
		throw new StackUnderflowException();
	}

	/**
	 * @return number of elements currently in the link list
	 */
	@Override
	public int size() {
		
		return numOfElements;
	}

	/**
	 * creates a new node and makes that new node the
	 * first node of the link list
	 * @return true if element was successfully added 
	 * @throws StackOverflowException if stack is full
	 */
	@Override
	public boolean push(T e) throws StackOverflowException {
		
		if(numOfElements < size) {
			Node temp = new Node(e);
			temp.next = head;
			head = temp;
			numOfElements++;
			return true;
		}
		
		throw new StackOverflowException();
	
		
	}
	
	/**
	 * returns a toString of the stack with the first element being the bottom
	 * of the stack.
	 * iterates through the link list popping every element out to be placed
	 * into an array. the array is then added backwards from last element
	 * to first into a temp string which is returned.
	 * @return string of stack with first element being the bottom of the stack
	 */
	@Override
	public String toString() {
		int counter = 0;
		String[] stack = new String[size()];
		Node currNode = head;
		while(counter < numOfElements && currNode != null ) {
			stack[counter] = currNode.data.toString();
			currNode = currNode.next;
			counter++;
		}
		
		String temp = "";
		for(int i = numOfElements-1; i >=0 ; i--) {
			temp += stack[i];
		}
		
		return temp;
	}

	
	/**
	 * returns a toString of the stack with the first element being the bottom
	 * of the stack.
	 * iterates through the link list popping every element out to be placed
	 * into an array. Then delimiter is placed between each value of the element
	 * @return string of stack with first element being the bottom of the stack
	 * @param delimiter of what the user wants between each element
	 */
	@Override
	public String toString(String delimiter) {
		int counter = 0;
		String[] stack = new String[numOfElements];
		Node currNode = head;
		while(counter < numOfElements && currNode != null ) {
			stack[counter] = currNode.data.toString();
			currNode = currNode.next;
			counter++;
		}
		
		
		String temp = "";
		for(int i = numOfElements-1; i >=0 && stack[i] != null; i--) {
			temp += stack[i] + delimiter;
		}
		
		temp = temp.substring(0,numOfElements+numOfElements-1);
		
		return temp;
	}
	
	
	/**
	 * Checks if number of elements is less than link list max size
	 * if so, the parameter list is copied into a tempList, which
	 * then the tempList is push into the link list
	 * @param ArrayList<T> list of what the user wants to be added to the 
	 * stack
	 * @throws StackOverflowException if number of elements is equal to or greater than link list max size. also
	 * throws StackOverflowException if list gets full after pushing. 
	 */
	@Override
	public void fill(ArrayList<T> list) throws StackOverflowException{
		
		if(numOfElements < size) {
			ArrayList<T> listTemp = new ArrayList<T>();
			for(int i = 0; i < list.size();i++) 
				listTemp.add(list.get(i));
			
			for(int i = 0; i < list.size();i++)
				push(listTemp.get(i));
		
		} else {
			throw new StackOverflowException();
		}
		
		
	}
	
	

}
