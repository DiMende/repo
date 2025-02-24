import java.util.ArrayList;
import exceptions.notation.*;
/**
 * A queue list that is implements QueueInterface and also implements a link list
 * @author Diego Mendez
 * @param <T>
 */
public class MyQueue<T> implements QueueInterface<T> {
	
	/**
	 * head points to the first node of the link list
	 * tail points to the last node of the link list
	 * numOfElements is the number of elements in the link list
	 * size is the max size of the link list
	 */
	private int size;
	private int numOfElements;
	private Node head;
	private Node tail;
	
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
	 * Initializes a queue link list array with 
	 * size set by user 
	 * @param size
	 */
	
	public MyQueue (int size) {
		numOfElements = 0;
		this.size = size;
		head = null;
		tail = null;
	}
	/**
	 * Initializes a queue link list array with 
	 * default size of 2
	 * 
	 */
	public MyQueue() {
		numOfElements = 0;
		size = 2;
		head = null;
		tail = null;
	}
	
	/**
	 * checks if head of link list is empty, if so
	 * that means that the link list is empty
	 * @return true if head is null, false otherwise
	 */
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
	 * returns the first element of the link list if link list is not empty
	 * @return first element of the link list
	 * @throws QueueUnderflowException if head is null
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		if(!isEmpty()) {
			T temp = head.data;
			head = head.next;
			numOfElements--;
			return (T) temp;
		}
		throw new QueueUnderflowException();
	}

	/**
	 * returns number of elements in the link list
	 * @return numOfElemets
	 */
	@Override
	public int size() {
		return numOfElements;
	}
	
	/**
	 * if the number of elements is less than size, and number of elements is 0,
	 * head and tail is initialized to a new node holding data. numOfElements is increased by 1
	 * if the number of elements is less than size, and number of elements is not 0,
	 * a temp node is created, tail.next points to the new temp node, and tail points back
	 * to tail.next which is now pointing to temp. numOfElements is increased by 1
	 *  @return true if element was successfully added
	 *  @throws QueueOverflowException if numOfElements more than size
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		if(numOfElements < size) {
			if(numOfElements == 0) {
				head = new Node(e);
				tail = head;
				numOfElements++;
				return true;
			}else {
				Node temp = new Node(e);
				tail.next = temp;
				tail = tail.next;
				numOfElements++;
				return true;
			}
		}
		
		throw new QueueOverflowException();
	}
	
	/**
	 * iterates through the queue link list and places each toString value of the object into a string named temp
	 * then returns temp
	 * @return temp, which is a string of the entire queue with the first element as the first added element
	 */
	@Override
	public String toString(){
		int counter = 0;
		String temp = "";		
		Node currNode = head;
		while(counter < numOfElements && currNode != null ) {
			temp += currNode.data.toString();
			currNode = currNode.next;
			counter++;
		}
		
		
		return temp;
	}
	
	/**
	 * a toString that returns the entire queue with the first element being the first object in the string.
	 * Places delimiter between each string
	 * @param delimiter that is placed between each element 
	 * @return string of queue with first element being the first and with delimiter that is placed
	 * between each element
	 */
	@Override
	public String toString(String delimiter) {
		int counter = 0;
		String temp = "";		
		Node currNode = head;
		while(counter < numOfElements && currNode != null ) {
			temp += currNode.data.toString() + delimiter;
			currNode = currNode.next;
			counter++;
		}
		
		temp = temp.substring(0,numOfElements+numOfElements-1);
		
		
		return temp;
	}
	
	/**
	 * Checks if number of elements is less than link list max size
	 * if so, the parameter list is copied into a tempList, which
	 * then the tempList is enqueued into the link list
	 * @param ArrayList<T> list of what the user wants to be added to the 
	 * queue
	 * @throws QueueOverflowException if number of elements is equal to or greater than link list max size. also
	 * throws QueueOverflowException if list gets full after enqueuing. 
	 *  
	 */
	@Override
	public void fill(ArrayList<T> list) throws QueueOverflowException{
		if(numOfElements < size) {
			ArrayList<T> listTemp = new ArrayList<T>();
			for(int i = 0; i < list.size();i++) 
				listTemp.add(list.get(i));
			for(int i = 0; i < list.size();i++)
				enqueue(list.get(i));
		} else {
			throw new QueueOverflowException();
		}
		
	}
	
	
}
